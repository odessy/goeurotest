package goeuro;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 
 * @author Odessy
 *
 */
public class CSV {
	
	private String fileName;
	private static final String comma = ",";
	private static final String nl = "\n";

	CSV(String fileName)
	{
		this.fileName = fileName;
	}
	
	/**
	 * 
	 * @param responses
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public void writeToFile(ArrayList<Response> responses) throws FileNotFoundException, UnsupportedEncodingException
	{
		
		PrintWriter writer = new PrintWriter(fileName);
		
		for(Response re : responses)
		{
			writer.write(re.id + comma + re.name + comma + re.type +
					comma + re.latitude + comma + re.longitude + nl);
		}
		
		writer.close();
	}
}
