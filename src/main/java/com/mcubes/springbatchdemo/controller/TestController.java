package com.mcubes.springbatchdemo.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    @ResponseBody
    @RequestMapping({"/", "test"})
    public String test(){
        return "Application is running...";
    }


    @ResponseBody
    @RequestMapping("/load-info")
    public String loadBulkFileAndSaveToDatabase() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        Map<String, JobParameter> map = new HashMap<>();
        map.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(map);
        JobExecution jobExecution = jobLauncher.run(job, jobParameters);
        System.out.println("Start at : " + jobExecution.getStartTime().toLocaleString());
        System.out.println("Running...");
        while (jobExecution.isRunning()){
            System.out.println(".");
        }
        System.out.println("Finished at : " + jobExecution.getEndTime().toLocaleString());
        return jobExecution.getStatus().toString();
    }

}
