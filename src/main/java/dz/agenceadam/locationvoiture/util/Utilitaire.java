package dz.agenceadam.locationvoiture.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Utilitaire {

	public static Date sdf(String pattern,String dateStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.parse(dateStr);
	}
	
	public static List<Integer> generateDaysOfMonthAndYears(int year,int month)
	{
		List<Integer> tabDays = new ArrayList<>();
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth(); //28 
		for(int x=1;x<=daysInMonth;x++)
		{
			tabDays.add(x);
		}
		
		return tabDays;
	}
	
	public static Map<Integer, Date> generateDaysOfMonthAndYearsDates(int year,int month) throws ParseException
	{
		Map<Integer,Date> tabDays = new HashMap<>();
		YearMonth yearMonthObject = YearMonth.of(year, month);
		int daysInMonth = yearMonthObject.lengthOfMonth(); //28 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		for(int x=1;x<=daysInMonth;x++)
		{
			LocalDate ld = LocalDate.of( year , month , x );
			tabDays.put(x, sdf.parse(ld.toString()));
		}
		
		return tabDays;
	}
}
