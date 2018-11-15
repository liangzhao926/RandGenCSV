package Common;


public class Config {

	public static final int IMSI_LEN = 15;
	public static final int IMEI_LEN = 15;
	
	public static final int USERS_PER_MNC = 10;
	
	public static String getAppFilePath() {
		return "app.csv";
	}
	public static String getAppProtoFilePath() {
		return "app-proto.csv";
	}
	public static String getIpProtoFilePath() {
		return "ip-proto.csv";
	}
	public static String getMccMncFilePath() {
		return "mcc-mnc.csv";
	}
	
	public static String[] getSelectedColumnNames() {
		String [] names = {"name", "weight"}; 
		return names;
	}
}
