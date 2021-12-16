package serializationOrdeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.rmgyantra.pojolib.pojoLibrary;

public class Serialization {

	public void serial() throws JsonGenerationException, JsonMappingException, IOException {
		
		pojoLibrary pObj=new pojoLibrary("Raj tyss","TestrYantra","Completed", 01);
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./jsonvalue"),pObj );
	}
}
