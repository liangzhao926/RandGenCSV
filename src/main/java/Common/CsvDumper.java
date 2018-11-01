package Common;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import DpiDump.Record;


public class CsvDumper {
	//CSVPrinter printer = null;
	public ObjectWriter writer = null;
	//private static Logger log = LoggerFactory.getLogger(CsvDumper.class);
	
	
	public CsvDumper() throws IOException {
		super();
		CsvMapper mapper = new CsvMapper();
		  // we ignore unknown fields or fields not specified in schema, otherwise
		  // writing will fail
		  //mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
		 
		  // initialize the schema
		CsvSchema schema = mapper.schemaFor(Record.class).withHeader(); 
				/*CsvSchema.builder().setUseHeader(true).build();*/
				//CsvSchema.emptySchema().withHeader();

		writer = mapper.writerFor(Record.class).with(schema);
		  // map the bean with our schema for the writer
//		  ObjectWriter writer = mapper.writerFor(OfferTemplateCategory.class).with(schema);
		 
	}


	public void dump(List<Record> records, String filePath) {
		  // we write the list of objects
		  try {
			  File tempFile = new File(filePath);
			  writer.writeValues(tempFile).writeAll(records);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	}

}
