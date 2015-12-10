package goeuro;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * 
 * @author Odessy
 *
 */
public class ApiInterface {
	
	private String url;
	private String query;
	private JsonArray jsonArray;
	
	ApiInterface(String url, String query){
		setUrl(url);
		setQuery(query);
	}
	
	/**
	 * 
	 * @param url
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}
	
	/**
	 * 
	 * @param query
	 */
	public void setQuery(String query)
	{
		this.query = query;
	}
	
	/**
	 * 
	 * @return the full url consisting of the query
	 */
	public String getFullUrl()
	{
		return this.url + this.query;
	}
	
	/**
	 * @param url
	 * @return
	 * @throws MalformedURLException
	 */
	protected URL getUrl(String url) throws MalformedURLException{
		return new URL(url);
	}
	
	/**
	 * 
	 * @return 
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public void apiCall() throws MalformedURLException, IOException{
		
		URL url = getUrl(getFullUrl());
		
		InputStream inputStream = url.openStream();
		
		JsonReader reader = Json.createReader(inputStream);
		
		this.jsonArray = reader.readArray();
	}
	
	
	/**
	 * 
	 * @return ArrayList of responses
	 */
	public ArrayList<Response> parseResponse(){
		
		int cnt = 0;
		
		ArrayList<Response> responses = new ArrayList<Response>(0);
		
		for (JsonObject obj : jsonArray.getValuesAs(JsonObject.class)){
			
			Response response = new Response();
			
			response.id = obj.getInt("_id");
			response.name = obj.getString("name");
			response.type = obj.getString("type");
			
			JsonObject geoPosition = obj.getJsonObject("geo_position");
			
			response.latitude = Float.parseFloat(geoPosition.get("latitude").toString());
			response.longitude = Float.parseFloat(geoPosition.get("longitude").toString());
			
			responses.add(response);
			
			System.out.println("Respone: " + cnt + " " + response.toString());
			
			cnt++;
		}
		
		return responses;
	} 

}
