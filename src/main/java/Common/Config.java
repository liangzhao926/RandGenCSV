package Common;


public class Config {

	public static final int IMSI_LEN = 15;
	public static final int IMEI_LEN = 15;
	
	public static final int USERS_PER_MNC = 10;
	
	public static String getComonFilePath() {
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		if (path.contains("WEB-INF")) {// for Tomcat environment
			path = path.replace("file:", "");
		} else {// for Eclipse environment
			path = "src/main/resources/";
		}
		return path;
	}
	
	public static String getAppFilePath() {
		String fileName = "app.csv";
		return getComonFilePath()+fileName;
	}
	public static String getAppProtoFilePath() {
		String fileName = "app-proto.csv";
		return getComonFilePath()+fileName;
	}
	public static String getIpProtoFilePath() {
		String fileName = "ip-proto.csv";
		return getComonFilePath()+fileName;
	}
	public static String getMccMncFilePath() {
		String fileName = "mcc-mnc.csv";
		return getComonFilePath()+fileName;
	}
	public static String getOutputFilePath() {
		String fileName = "dpi-dump.csv";
		return getComonFilePath()+fileName;
	}
	
	public static String[] getSelectedColumnNames() {
		String [] names = {"name", "weight"}; 
		return names;
	}
}
