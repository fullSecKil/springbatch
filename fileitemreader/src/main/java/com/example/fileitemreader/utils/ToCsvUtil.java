package com.example.fileitemreader.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.apache.poi.ss.usermodel.CellType.*;

/**
 * @file: ToCsvUtil.class
 * @author: Dusk
 * @since: 2019/5/14 15:45
 * @desc:
 */
@Component
public class ToCsvUtil {
    @Value("classpath*:/data/init/xlsx/SINANO_*.xlsx")
    private Resource[] resources;

    public void execute() throws IOException {
        Map<String, XSSFSheet> fileInputStreamMap = new HashMap<>(60);
        for (Resource resource : resources) {
            XSSFSheet xssfSheet = new XSSFWorkbook(new BufferedInputStream(resource.getInputStream())).getSheetAt(0);
            fileInputStreamMap.putIfAbsent(resource.getFilename().split("\\.")[0], xssfSheet);
        }
        // ResourceUtils.getURL("classpath:data/init").getPath()
        File csvPath = new File(ResourceUtils.getURL("classpath:data/init").getPath(), "csv");
        if (!csvPath.exists()) {
            csvPath.mkdirs();
        }
        fileInputStreamMap.forEach((key, value) -> {

            File file = new File(csvPath, String.format("%s.%s", key, "csv"));
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                FileChannel fileChannel = fileOutputStream.getChannel();
                ByteBuffer buf = ByteBuffer.allocate(1024);
                int rows = value.getPhysicalNumberOfRows();
                // 将excel中所有行遍历结果为a,b,c的list
                List<String> collect = IntStream.rangeClosed(0, rows - 1).mapToObj(value::getRow).map(r -> IntStream.rangeClosed(0, r.getPhysicalNumberOfCells() - 1).mapToObj(r::getCell).filter(Objects::nonNull).map(t -> {
                    if (t.getCellType() == NUMERIC) {
                        return String.valueOf(t.getNumericCellValue());
                    } else if (t.getCellType() == STRING) {
                        return String.valueOf(t.getStringCellValue());
                    } else {
                        return "-";
                    }
                }).collect(joining(","))).collect(Collectors.toList());
                // 设置utf-8 bom头
                Optional.ofNullable(collect.get(0)).ifPresent(s -> collect.set(0, String.format("%c%s", '\ufeff', s)));
                collect.stream().map(s -> {
                    try {
                        String v = String.format("%s%s", s, "\r\n");
                        return v.getBytes("utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).filter(Objects::nonNull).forEach(b -> {
                    buf.put(b);
                    buf.flip();
                    while (buf.hasRemaining()) {
                        try {
                            fileChannel.write(buf);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    buf.compact();
                });
                fileChannel.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }

}
