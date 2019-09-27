package dao_test;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class EnoshTest {

	static Date getDate(LocalDateTime dateToConvert) {
	    return java.util.Date
	      .from(dateToConvert.atZone(ZoneId.systemDefault())
	      .toInstant());
	}
	
	public static void main(String[] args) {
		LocalDateTime t = LocalDateTime.now();
		System.out.println(t);
		Date d = getDate(t);
		System.out.println(d);
	}
	
	
	
}
