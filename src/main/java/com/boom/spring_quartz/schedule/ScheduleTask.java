package com.boom.spring_quartz.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.err.println("这是一个job");
	}
	
	public void say(){
		System.err.println("大世界");
	}

}
