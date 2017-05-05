package com.rana.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RecurringDates {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat sd1 = new SimpleDateFormat("dd-MM-yyyy EEEE");
		String fdate = "25-04-2017";
		String tdate = "25-05-2017";
		System.out.println(sd.parse(fdate));
		
		Date from_date = sd.parse(fdate);
		Date to_date = sd.parse(tdate);

		List<Date> calcDates = calculateRecurringDates(from_date, to_date, "WEEKLY", "2,3");
		for (Date date : calcDates) {
			
			System.out.println(sd1.format(date));
		}
		
	}
	
	
	private static List<Date> calculateRecurringDates(Date from_date, Date to_date, String rec_type, String days_of_week) {

		List<Date> recurringDateList = new ArrayList<Date>();


		switch (rec_type) {
		case "DAILY": {
			recurringDateList.add(from_date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(from_date);
			while (from_date.before(to_date) ) {
				cal.add(Calendar.DATE, 1);
				from_date = cal.getTime();
				recurringDateList.add(from_date);
			}
			break;
		}
		case "WEEKLY": {
			Calendar cal = Calendar.getInstance();
			while (from_date.before(to_date) ) {
				cal.setTime(from_date);

				List<Integer> inputDays = new ArrayList<Integer>();
				for (String day : days_of_week.split(",")) {
					inputDays.add(Integer.valueOf(day));
				}

				//				List inputDays = Arrays.asList(days_of_week.split(","));
				if(inputDays.contains(cal.get(Calendar.DAY_OF_WEEK))) {
					recurringDateList.add(from_date);
				}
				cal.add(Calendar.DATE, 1);
				from_date = cal.getTime();
			}
			break;			
		}
		case "MONTHLY": {
			recurringDateList.add(from_date);
			Calendar cal = Calendar.getInstance();
			cal.setTime(from_date);
			while (from_date.before(to_date) ) {
				cal.add(Calendar.MONTH, 1);
				from_date = cal.getTime();
				recurringDateList.add(from_date);}
		}


		default:
			break;
		}
		return recurringDateList;

	}
}
