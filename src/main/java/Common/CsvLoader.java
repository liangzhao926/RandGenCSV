package Common;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csvreader.CsvReader;

public class CsvLoader {
	private static Logger log = LoggerFactory.getLogger(CsvLoader.class);
	
	public static RandomCollection<String> load(String filePath) {
		
		try {
			File file = new File(filePath);
			if(!file.exists()){
				log.error("{} is not found", filePath);
				return null;
			}
			FileInputStream in = new FileInputStream(file);
			CsvReader csv = new CsvReader(in, Charset.forName("UTF-8"));
			if (!csv.readHeaders()) {
				log.error("failed to read from {}", filePath);
				return null;
			}
			List<String> headers = Arrays.asList(csv.getHeaders());
			/* too few to justify any sorting
			Collections.sort(headers);
			*/
			String[] selected = Config.getSelectedColumnNames();
			int [] colIndex = {-1,-1};
			
			for (int i = 0; i < selected.length; i++) {
				if (headers.contains(selected[i])) {
					colIndex[i] = i;
					log.info("Column {} for {}", i, selected[i]);
					
				}
			}
			/*
			for (int i = 0; i < csv.getHeaderCount(); i++) {
				if (fieldNames.contains(headers[i])) {
					Pair pair = new Pair(i, headers[i]);
					readHeaders.add(pair);
					log.info("Column {} for {}", i, headers[i]);
				}
			}
			*/
				
			RandomCollection<String> map = new RandomCollection<String>();
			while (csv.readRecord()) {
				map.add(
						csv.get(colIndex[0]),
						Double.valueOf(csv.get(colIndex[1])));
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
