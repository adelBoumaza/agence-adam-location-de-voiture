package dz.agenceadam.locationvoiture.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public interface IConstant {

	public interface IDateFormat {
			
			final static DateTimeFormatter DD_MMMM_YYYY = DateTimeFormat.forPattern("dd MMMM yyyy").withLocale(Locale.FRANCE);
			final static DateTimeFormatter EEEE_DD_MMMM_YYYY = DateTimeFormat.forPattern("EEEE dd MMMM yyyy").withLocale(Locale.FRANCE);
			final static SimpleDateFormat DD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");
			final static SimpleDateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy/MM/dd");
			final static SimpleDateFormat YYYYMMdd = new SimpleDateFormat("yyyy-MM-dd");
			final static DateTimeFormatter DTF_DD_MM_YYYY = DateTimeFormat
					.forPattern("dd/MM/yyyy").withLocale(Locale.FRANCE);
			final static DateFormat SDF_MM_DD = new SimpleDateFormat("MM/dd");
			
	}
	
	public interface Statut{
		final static String STATUT_PAYE = "Payé";
		final static String STATUT_NON_PAYE = "Non Payé";
		final static String STATUT_PARTIELLEMENT_PAYE = "Partiellement Payé";
	}

}
