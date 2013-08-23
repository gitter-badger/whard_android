package hsb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.nino.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class HSBJson 
{
	Activity mActivity = null;
	
	public void SetActivity(Activity _activity) { mActivity = _activity; }
    public void JsonParse(String json)
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
			
			result.setText(resultStr);
		} 
		catch (JSONException e) 
		{
			Toast.makeText(mActivity, e.getMessage(), Toast.LENGTH_SHORT).show();
		}
	}
}
