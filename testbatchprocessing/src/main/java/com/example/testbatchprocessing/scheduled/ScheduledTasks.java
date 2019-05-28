package com.example.testbatchprocessing.scheduled;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @file: ScheduledTasks.class
 * @author: Dusk
 * @since: 2019/5/12 20:54
 * @desc:
 */
@Component
@EnableScheduling
/**
 * @Scheduled不执行的原因 添加@EnableScheduling注解
 * https://blog.csdn.net/qq_28773851/article/details/81558987
 */
public class ScheduledTasks {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Lazy
    private Job job;

    /**
     *  定时任务来执行 https://blog.csdn.net/u014172271/article/details/80413135
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void showCurrentTime() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        System.out.println(1);
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("startTime", new JobParameter(new Date()));
        jobLauncher.run(job, new JobParameters(parameterMap));
        System.out.println(1);
    }
}
