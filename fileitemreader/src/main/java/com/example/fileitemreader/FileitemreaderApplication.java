package com.example.fileitemreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dusk
 * 此项目我制作目标通过commandrunner中初始化调用ToCsvUtil 将xlsx文件写为csv文件，随后解析csv文件将csv数据
 * 用FeeRecord表示，remark中取出关键reservation id，随后通过各个要验证的field的参数进行数据库对比数据写入resultMessage
 * 在过滤非异常状态信息，再写入到result.txt中
 */
@SpringBootApplication
public class FileitemreaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileitemreaderApplication.class, args);
    }

}
