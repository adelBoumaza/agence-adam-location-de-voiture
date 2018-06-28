package dz.agenceadam.locationvoiture.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class Utilitaire {

	public static Date sdf(String pattern,String dateStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}
}
