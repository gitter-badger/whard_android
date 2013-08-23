package hsb;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class HSBHttp
{
	public static String doPost(String url, String params)
	{
		try
		{
	        //(1)
	        HttpPost method = new HttpPost( url );
	        
	        DefaultHttpClient client = new DefaultHttpClient();
	        
	        //(2)POST데이타 설정 
	        StringEntity paramEntity = new StringEntity( params );
	        paramEntity.setChunked( false );
	        //(3)
	        paramEntity.setContentType( "application/x-www-form-urlencoded" );
	        method.setEntity( paramEntity );
	        
	        HttpResponse response = client.execute( method );
	        int status = response.getStatusLine().getStatusCode();
	        if ( status != HttpStatus.SC_OK )
	            throw new Exception( "" );
	        
	        return EntityUtils.toString( response.getEntity(), "UTF-8" );
	    }
	    catch ( Exception e )
	    {
	        return null;
	    }
	}
	
	public static String parsingData(String[] val) throws UnsupportedEncodingException
	{
		String result;
		
		result = null;
		for(int i=0 ; i<val.length/2 ; i++)
		{
			result = result + val[i];
			result = result + "=";
			result = result + URLEncoder.encode(val[i+1], "EUC_KR");
			
			if(i != val.length-1)
				result = result + "&";
		}
		
		return result;
	}
	
	public static JSONArray parsingDataToJSON(String[] val)
	{
		JSONArray jsonArray;
		
		jsonArray = new JSONArray();
		
		for(int i=0 ; i<val.length ; i++)
			jsonArray.put(val[i]);
		
		return jsonArray;
	}
}
