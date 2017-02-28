package com.boom.spring_quartz.schedule;

import java.util.HashMap;
import java.util.Map;

import javax.sound.midi.SysexMessage;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Service;

import com.boom.spring_quartz.quartz.QuartzScheduleMgr;

@Service
public class ScheduleService {

	Scheduler scheduler = QuartzScheduleMgr.getInstanceScheduler();  
	
	private static Map<String, String> JOB_MAP =  new HashMap<>();
	private static Map<String, Job> JOB_ClASS =  new HashMap<>();
	private static ScheduleTask scheduleTask = new ScheduleTask();
	private static ScheduleTask2 scheduleTask2 = new ScheduleTask2();
	
	static {
		
		JOB_MAP.put("JOB1", "TRIGGER1");
		JOB_MAP.put("JOB2", "TRIGGER2");
		JOB_MAP.put("TRIGGER1", "GROUP1");
		JOB_MAP.put("TRIGGER2", "GROUP2");
		
		JOB_ClASS.put("JOB1", scheduleTask);
		JOB_ClASS.put("JOB2", scheduleTask2);
	}
	
	/**
	 * @param cronExpression 时间表达式
	 * @param jobName job名
	 * @throws SchedulerException
	 */
	public void createCron(String cronExpression, String jobName) throws SchedulerException{
		System.err.println("jobName:"+jobName);
		System.err.println("job1:"+JOB_MAP.get("JOB1"));
		System.err.println("JOB_MAP_SIZE:"+JOB_MAP.size());
		System.err.println("JOB_MAP.get(jobName):"+String.valueOf(JOB_MAP.get(jobName)));
		System.err.println("JOB_MAP.get(JOB_MAP.get(jobName)):"+JOB_MAP.get(JOB_MAP.get(jobName)));
		JobDetail job = JobBuilder.newJob(JOB_ClASS.get(jobName).getClass()).withIdentity(jobName, JOB_MAP.get(JOB_MAP.get(jobName))).build(); 
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(JOB_MAP.get(jobName), JOB_MAP.get(JOB_MAP.get(jobName)))  
		            .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))  
		            .startNow()  
		            .build();  
		if(!scheduler.isStarted()){  
            scheduler.start();  
        }
		scheduler.scheduleJob(job, trigger);//设置调度相关的Job  
	}
	
	public void setCron(String cronExpression, String jobName) throws SchedulerException{
		scheduler.pauseTrigger(TriggerKey.triggerKey(JOB_MAP.get(jobName), JOB_MAP.get(JOB_MAP.get(jobName))));
		scheduler.unscheduleJob(TriggerKey.triggerKey(JOB_MAP.get(jobName), JOB_MAP.get(JOB_MAP.get(jobName))));
		scheduler.deleteJob(JobKey.jobKey(jobName, JOB_MAP.get(JOB_MAP.get(jobName))));
		createCron(cronExpression,jobName);
	}
	
	public void pause(String jobName) throws SchedulerException{
		scheduler.pauseJob(JobKey.jobKey(jobName, JOB_MAP.get(JOB_MAP.get(jobName))));
	}
	
	public void delete(String jobName) throws SchedulerException{
		scheduler.deleteJob(JobKey.jobKey(jobName, JOB_MAP.get(JOB_MAP.get(jobName))));
	}
	
}
