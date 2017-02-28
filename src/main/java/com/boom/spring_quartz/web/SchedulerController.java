package com.boom.spring_quartz.web;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boom.spring_quartz.schedule.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class SchedulerController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping("")
	public String index(){
		return "index";
	} 
	
	@RequestMapping("/createCron")
	@ResponseBody
	public String createCron(String cronExpression,String jobName) throws SchedulerException {
		System.err.println("jobName:"+jobName);
		scheduleService.createCron(cronExpression, jobName);
		return "create success";
	}
	
	@RequestMapping("/setCron")
	@ResponseBody
	public String setCron(String cronExpression,String jobName) throws SchedulerException{
		scheduleService.setCron(cronExpression, jobName);
		return "set success";
	}
	
	@RequestMapping("/pauseJob")
	@ResponseBody
	public String pause(String jobName) throws SchedulerException{
		scheduleService.pause(jobName);
		return "pause success";
	}
	
	@RequestMapping("/deleteJob")
	@ResponseBody
	public String delete(String jobName) throws SchedulerException{
		scheduleService.delete(jobName);
		return "pause success";
	}
	
}
