package goeuro;

/**
 * 
 * @author Odessy
 *
 */
public class Response {
	
	public int id = 0;
	public String name = "";
	public String type = "";
	public float latitude = 0;
	public float longitude = 0;
	
	
	public String toString()
	{
		return "_id:" + id + " Name: " + name + " Type: " + type +
				" Lat: " + latitude + " Long: " + longitude;
	}
}
