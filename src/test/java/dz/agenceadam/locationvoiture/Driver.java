package dz.agenceadam.locationvoiture;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
	    
		
	}
	
	private static List<Integer> generateDaysOfMonthAndYears(int year,int month)
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

