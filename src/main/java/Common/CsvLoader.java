package Common;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csvreader.CsvReader;

public class CsvLoader {
	private class Pair {
		Integer index;
		String name;
		public Pair(Integer index, String name) {
			super();
			this.index = index;
			this.name = name;
		}
		
	}
	private static Logger log = LoggerFactory.getLogger(CsvLoader.class);
	
	public void load(String filePath, Class<?> clazz) {
		
		try {
			Instant start = Instant.now();
			File file = new File(filePath);
			if(!file.exists()){
				log.error("{} is not found", filePath);
				return;
			}
			FileInputStream in = new FileInputStream(file);
			CsvReader csv = new CsvReader(in, Charset.forName("UTF-8"));
			if (!csv.readHeaders()) {
				log.error("failed to read from {}", filePath);
				return;
			}
			String[] headers = csv.getHeaders();
			/* too few headers to justify any sorting
			Collections.sort(headers);
			*/
			List<Field> fields = Arrays.asList(clazz.getFields());
			List<String> fieldNames = new ArrayList<String>();
			for (Field field : fields) {
				fieldNames.add(field.getName());
			}
			Collections.sort(fieldNames);
			List<Pair> readHeaders = new ArrayList<Pair>();
			
			for (int i = 0; i < csv.getHeaderCount(); i++) {
				if (fields.contains(headers[i])) {
					Pair pair = new Pair(i, headers[i]);
					readHeaders.add(pair);
					log.info("Column {} for {}", i, headers[i]);
				}
			}
			log.error()
				System.out.printf("Column %d for lat, %d for lon\n", colLat, colLon);
				
				HashMap<String, GeoCoordinate> map = new HashMap<String, GeoCoordinate>();
				List<HashMap<String, GeoCoordinate>> mapList = new LinkedList<HashMap<String, GeoCoordinate>>();
				int i = 0, sub_i = 0;
				int batchSize = 10000;
				while (csv.readRecord()) {
					GeoCoordinate coord = new GeoCoordinate(
							Double.valueOf(csv.get(colLon)),
							Double.valueOf(csv.get(colLat)));
					map.put(String.valueOf(i), coord);
					i++;sub_i++;
					if (sub_i >= batchSize) {
						mapList.add(map);
						map = new HashMap<String, GeoCoordinate>();
						sub_i = 0;
					}
				}
				Instant endFile = Instant.now();
				System.out.println(String.valueOf(start.until(endFile, ChronoUnit.MILLIS)));
				
				JedisUtils.add(map);
				for (HashMap<String, GeoCoordinate> map1 : mapList) {
				JedisUtils.add(map1);
				}
				//add the odds
				if (!map.isEmpty()) {
				JedisUtils.add(map);
				}
				
				Instant endDb = Instant.now();
				System.out.println(String.valueOf(endFile.until(endDb, ChronoUnit.MILLIS)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

}
