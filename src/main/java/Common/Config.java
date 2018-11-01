package Common;


public class Config {

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
	public static String getOutputFilePath() {
		String fileName = "dpi-dump.csv";
		return getComonFilePath()+fileName;
	}
	
	public static String[] getSelectedColumnNames() {
		String [] names = {"name", "weight"}; 
		return names;
	}
}
