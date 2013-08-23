package hsb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;


public class HSBJson 
{
	static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";
    private static Activity mActivity = null;

    public static void SetActivity(Activity _activity) { mActivity = _activity; }

	public static void parsingJSONToData(String url)
	{
		JSONArray contacts = null;
		
		// getting JSON string from URL
		JSONObject json = getJSONFromUrl(url);
		 
		try {
		    // Getting Array of Contacts
		    contacts = json.getJSONArray(TAG_CONTACTS);
		     
		    // looping through All Contacts
		    for(int i = 0; i < contacts.length(); i++){
		        JSONObject c = contacts.getJSONObject(i);
		         
		        // Storing each json item in variable
		        String id = c.getString(TAG_ID);
		        String name = c.getString(TAG_NAME);
		        String email = c.getString(TAG_EMAIL);
		        String address = c.getString(TAG_ADDRESS);
		        String gender = c.getString(TAG_GENDER);
		         
		        // Phone number is agin JSON Object
		        JSONObject phone = c.getJSONObject(TAG_PHONE);
		        String mobile = phone.getString(TAG_PHONE_MOBILE);
		        String home = phone.getString(TAG_PHONE_HOME);
		        String office = phone.getString(TAG_PHONE_OFFICE);
		         
		    }
		} catch (JSONException e) {
		    e.printStackTrace();
		}
	}
	
    public static void JsonParse(String json)
    {        
		String resultStr = "";

		try 
		{
			JSONArray jArr = new JSONArray(json);

			for (int i = 0; i < jArr.length(); i++) 
			{
				JSONObject jObj = jArr.getJSONObject(i);
				resultStr += String.format("아이디 : %s   전화번호 : %s\n",
						jObj.getString("id"), jObj.getString("tel"));
			}
			
			//result.setText(resultStr);
		} 
		catch (JSONException e) 
		{
			//Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
	
	public static JSONObject getJSONFromUrl(String url) {
		 
        // Making HTTP request
        try {
            // defaultHttpClient
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
 
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();           
 
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            json = sb.toString();
        } catch (Exception e) {
            Log.e("Buffer Error", "Error converting result " + e.toString());
        }
 
        // try parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (JSONException e) {
            Log.e("JSON Parser", "Error parsing data " + e.toString());
        }
 
        // return JSON String
        return jObj;
    }
}
