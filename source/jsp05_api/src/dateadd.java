import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateadd {
	//날짜 더하기 메소드
	public static String dateAdd(String date, int addDay) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String caldate = null;//계산된 날짜
		try {
			Date d = sdf.parse(date);  //문자열을 날짜형으로 변경
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(d);
	        cal.add(Calendar.DATE, addDay);

	        caldate = sdf.format(cal.getTime()); //날짜형을 문자열로 변경

		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		return caldate;
		
	}
	
	public static void main(String[] args) throws ParseException {
		//날짜 더하기 테스트 
		String date = "20210530";
		System.out.println("하루전:" + dateadd.dateAdd(date, -1));
		
		
		
	}
}
