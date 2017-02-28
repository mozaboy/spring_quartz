package com.boom.spring_quartz.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask2 implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.err.println("这是一个job2");
	}
	
	public void say(){
		System.err.println("大世界");
	}

}
