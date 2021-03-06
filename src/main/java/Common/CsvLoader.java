package Common;

import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CsvLoader {
	private static Logger log = LoggerFactory.getLogger(CsvLoader.class);
	
	public static RandomCollection<String> load(String filePath) {

		try (Reader in = new InputStreamReader(RandomCollection.class.getClassLoader().getResourceAsStream(filePath))){
			if (!in.ready()){
				log.error("cannot read {}", filePath);
				in.close();
				return null;
			}
			Iterable<CSVRecord> records = CSVFormat.RFC4180.withHeader().parse(in);
			RandomCollection<String> map = new RandomCollection<String>();
			for (CSVRecord record : records) {
				map.add(record.get(0), Double.valueOf(record.get(1))); 
			}
			in.close();
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return null;
	}

}
