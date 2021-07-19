package ex11_batch;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class Ex01_TestJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		//작업 내용
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
				
		Date time = new Date();
				
		String time1 = format1.format(time);
				
		System.out.println(time1);
		
		
		
		
	}
	
}
