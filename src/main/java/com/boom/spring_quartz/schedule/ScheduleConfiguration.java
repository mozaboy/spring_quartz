package com.boom.spring_quartz.schedule;


//@Configuration
public class ScheduleConfiguration {

//	@Bean(name = "detailFactoryBean")
//	public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask scheduleTask){
//		MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
//		bean.setTargetObject(scheduleTask);
//		bean.setTargetMethod("say");
//		bean.setConcurrent(false);
//		return bean;
//	}
//	
//	@Bean(name = "cronTriggerBean")
//	public CronTriggerBean cronTriggerBean(MethodInvokingJobDetailFactoryBean detailFactoryBean){
//		CronTriggerBean trigger = new CronTriggerBean();
//		trigger.setJobDetail(detailFactoryBean.getObject());
//		trigger.setName("cron1");
//		trigger.setGroup("group1");
//		try {
//			trigger.setCronExpression("0/5 * * * * ?");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return trigger;
//	}
//	
//	@Bean
//	public SchedulerFactoryBean schedulerFactory(CronTriggerBean[] cronTriggerBean){
//		SchedulerFactoryBean bean = new SchedulerFactoryBean();
//		bean.setTriggers(cronTriggerBean);
//		return bean;
//	}
//	
//	@Bean
//	public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean){
//		return schedulerFactoryBean.getObject();
//	}
	
}
