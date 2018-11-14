package Common;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class RandUtils {
	static Random rand = new Random();
	private static final Double min = 103.5;
	private static final Double mean = 4000.0;
	private static final Double std = 4000.0;
	
	public static Integer nextNormal(Double mean, Double std, Double min, Double max) {
		Double r = rand.nextGaussian();
		r *= std;
		r += mean;
		if (min != null && r < min) {
			r = min;
		} else if (max != null && r >max){
			r = max;
		}
		return r.intValue();
	}
	public static Integer nextNormal(int mean, int std, int min, int max) {
		return nextNormal((double)mean,
				(double)std,
				(double)min,
				(double)max);
				
	}
	
	public static Integer nextExp(double beta, int min, int max) {
		Double lambda = 1/beta;
	    Double r =  Math.log(1-rand.nextDouble())/(-lambda);
	    int retInt = r.intValue();
		if (retInt < min) {
			retInt = min;
		} else if (retInt > max) {
			retInt = max;
		}
		return retInt;
	}

	//including max
	public static int nextInt(int min, int max) { 
		 
        // Usually this can be a field rather than a method variable 
        //Random rand = new Random(); 
 
        // nextInt is normally exclusive of the top value, 
        // so add 1 to make it inclusive 
        int randomNum = rand.nextInt((max - min) + 1) + min; 
 
        return randomNum; 
    } 
	
	public static String nextIntString(int len) { 
        String ret = ""; 
         
        for (int i = 0; i < len; i++) { 
            ret += String.valueOf(nextInt(0, 9)); 
        } 
         
        return ret; 
    } 

	public static String nextIpv4() {
		return 
				rand.nextInt(256) + "." + 
				rand.nextInt(256) + "." + 
				rand.nextInt(256) + "." + 
				rand.nextInt(256);
	}
	
	private static final String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyz0123456789";
	public static String nextWord(int count) {
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

	private static final String [] DOMAIN_NAME_EXT = {
			".com",
			".org",
			".net",
			".us",
			".co",
			".io",
			".biz" ,
			".info" ,
			".jobs" ,
			".mobi" ,
			".name" ,
			".ly" ,
			".tel" ,
			".kitchen" ,
			".email" ,
			".tech" ,
			".estate" ,
			".xyz" ,
			".codes" ,
			".bargains" ,
			".bid" ,
			".expert"	,	
	};
	public static String nextDomainNameExt() {
		int index = (int)(Math.random()*DOMAIN_NAME_EXT.length);
		return DOMAIN_NAME_EXT[index];
	}
	
	public static String nextDomainName(int numSegs) {
		String domainName = nextWord(nextInt(3,5));
		while(numSegs-- >=0) {
			domainName += "."+nextWord(nextInt(3,18));
		}
		domainName += nextDomainNameExt();
		return domainName;
	}
	
	public static String nextApn(int numSegs) {
		String domainName = nextWord(nextInt(3,5));
		while(numSegs-- >=0) {
			domainName += "."+nextWord(nextInt(3,5));
		}
		return domainName;
	}
	
	public static String nextPath(int numSegs) {
		String path = nextWord(nextInt(5,12));
		while(numSegs-- >=0) {
			path += "/"+nextWord(nextInt(5,12));
		}
		return path;
	}
	
	public static String nextUrl() {
		String url = "http";
		if (rand.nextBoolean()) {
			url += "s";
		}
		url += "://" + nextDomainName(nextInt(3,7)) + nextPath(nextInt(2,5)); 
		return url;
	}
	
	public static boolean nextBoolean() {
		return rand.nextBoolean();
	}
	
	protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
			.ofPattern("yyyy-MM-dd HH:mm:ss")
			.withZone(ZoneId.systemDefault());

	public static String nextTimestamp() {
        GregorianCalendar gc = new GregorianCalendar();

        int year = nextInt(2016, 2018);

        gc.set(Calendar.YEAR, year);

        int dayOfYear = nextInt(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        
        Instant ins = gc.toInstant();
        int seconds = RandUtils.nextNormal(21*60*60, 2*60*60, 0, 24*60*60-1); // use 9pm as mean
        ins = ins.plusSeconds(seconds);
        return DATE_TIME_FORMATTER.format(ins);

	}
	
	private static final String [] RAT = {"GERAN", "UTRAN", "EUTRAN", "WIMAX", "WIFI"};
	public static String nextRat() {
		int index = (int)(Math.random()*RAT.length);
		return RAT[index];
	}
	
	
}
