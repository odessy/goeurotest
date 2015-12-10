package goeuro;

public class Driver {
	
	public static void main(String [] args)
	{
		
		CSV file = new CSV("response.csv");

		String query = readQuery(args);
		
		String url = "http://api.goeuro.com/api/v2/position/suggest/en/";
		
		if( query != null)
		{
			ApiInterface api = new ApiInterface( url, query);
		
			try
			{
				//call the api
				api.apiCall();
				
				//write responses to file
				file.writeToFile(api.parseResponse());	
			}
			catch(Exception ex){
				
				System.err.println("Error Occured: "+ex.getMessage());
				System.exit(0);
			}
		
		}
		else
		{
			System.out.println( "Usage: \"CITY_NAME\" " );
		}
		
	}
	
	public static String readQuery(String [] args)
	{
		if(args.length > 0)
		{
			return args[0];
		}
		
		return null;
	}

}
