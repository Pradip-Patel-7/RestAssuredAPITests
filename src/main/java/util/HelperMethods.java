package util;


import java.text.SimpleDateFormat;
import java.util.Date;

public class HelperMethods {
	
	public static String getTodayDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);

        // Get the current date
        Date date = new Date();
		
		return sdf.format(date);
	}

}
