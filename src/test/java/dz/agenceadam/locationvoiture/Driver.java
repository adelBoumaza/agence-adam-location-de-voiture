package dz.agenceadam.locationvoiture;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;


public class Driver {

	public static void main(String[] args) throws ParseException {
	    
		Map<Integer, Date> tab = generateDaysOfMonthAndYears(2018, 9);
		System.out.println(tab);
		

	}
	
	public static Map<Integer, Date> generateDaysOfMonthAndYears(int year,int month) throws ParseException
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
	
	private static List<Integer> generateDaysOfMonthAndYearsE(int year,int month)
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
}

