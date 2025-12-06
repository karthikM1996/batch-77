package genericutility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JavaUtility {

	public String togetrequiredate(int day) {
	
	java.util.Date d=new java.util.Date();
	 SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	 String current = sim.format(d);
	 Calendar cal = sim.getCalendar();
	 cal.add(cal.DAY_OF_MONTH, day);
	 String requiredate = sim.format(cal.getTime());
	 return requiredate;
}
}
