package com.example.fileitemreader.scheduled;

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
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@EnableScheduling
@Lazy
public class ScheduledTask {
    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public void launcher() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String, JobParameter> parameterMap = new HashMap<>();
        parameterMap.put("startTime", new JobParameter(new Date()));
        jobLauncher.run(job, new JobParameters(parameterMap));
    }
}
