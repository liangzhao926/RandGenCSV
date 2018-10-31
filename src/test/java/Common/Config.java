package Common;


public class Config {
	public static String getOutputFilePath() {
		String fileName = "foo.csv";
		String path = Thread.currentThread().getContextClassLoader().getResource("").toString();
		if (path.contains("WEB-INF")) {// for Tomcat environment
			path = path.replace("file:", "");
			path += fileName;
		} else {// for Eclipse environment
			path = "src/main/resources/" + fileName;
		}
		return path;
	}
}
