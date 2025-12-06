package genericutilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {

	public String TogetExpectedDate(int days)
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd_MM_yyyy");
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
	String expdate = sim.format(cal.getTime());
		return expdate;
	}
}
