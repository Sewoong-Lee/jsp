package ex11_batch;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Ex02_Quariz2 {

	public static void main(String[] args) {
		//배치 애플리케이션
		
		StdSchedulerFactory sf= new StdSchedulerFactory();
		try {
			//스케쥴 객체
			Scheduler sd = sf.getScheduler();
			
			//1) 작업 생성 (어떤 작업을)
			JobDetail job = JobBuilder.newJob(Ex02_BoardCnt.class)
							.withIdentity("boaerdJob", Scheduler.DEFAULT_GROUP)
							.build();
			
			//2) 트리거 생성 (언제)
			//초 분 시간 일 월 요일 년도 
			//cron문법 : [Seconds] [Minutes] [Hours] [Day-of-month] [Month] [Day-of-Week] [Year]
			//? : 일과 요일 필드에 사용, 설정값 없음
			// 0 0/1 * * * ? : 1분간견
			// 0 0 0/1 * * ? : 1시간 간격
			Trigger trigger =TriggerBuilder.newTrigger()
							.withIdentity("testTrigger", Scheduler.DEFAULT_GROUP)
							.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")) //1분 마다
							.build();
			
			//작업, 트리거 넘겨주기
			sd.scheduleJob(job,trigger);
			sd.start();
			
			
			
			
			
			
			
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
