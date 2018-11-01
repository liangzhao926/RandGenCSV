package Common;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CsvDumper {
	private static Logger log = LoggerFactory.getLogger(CsvDumper.class);
	
	public static void dump(Iterable<?> list, String filePath) {
		try (CSVPrinter printer = new CSVPrinter(new FileWriter(filePath), CSVFormat.RFC4180)) {
			printer.printRecord(list);
		} catch (FileNotFoundException e) {
			log.error("{} is not found", filePath);
			return;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return;
	}

}
