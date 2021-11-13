package com.example.accident_alert_system;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class View_nearest_hospital_details extends Activity {
ListView li;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_nearest_hospital_details);
		li=(ListView)findViewById(R.id.listView1);
		new getjson2().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_nearest_hospital_details, menu);
		return true;
	}
	private class getjson2 extends AsyncTask<Void, Void, Void>{
		ArrayList<HashMap<String,String>> al=new ArrayList<HashMap<String,String>>();
				@Override
				protected Void doInBackground(Void... params) {
					// TODO Auto-generated method stub
					String url = "http://192.168.43.159:8000/hospital/android/";
					JSONArray jdata=JsonHandler.GetJson(url);
					if(jdata!=null)
					{
						try {
						for (int i = 0; i < jdata.length(); i++) {
		                    JSONObject c;
							c = jdata.getJSONObject(i);
		                    String h_name = c.getString("h_name");
		                    String address = c.getString("address");
		                    String place = c.getString("place");
		                    String phone = c.getString("phone");
		                    String email = c.getString("email");

		                    
		                    HashMap<String, String> contact =  new HashMap<String, String>();
		                    contact.put("h_name", h_name);
		                    contact.put("address", address);
		                    contact.put("place", place);
		                    contact.put("phone", phone);
		                    contact.put("email", email);

		                   
		                    
		                   // if(h_id.equals(cid))
		                    {
		                    al.add(contact);
		                   }
		                   
		                }
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							Toast.makeText(getApplicationContext(), "Not Registered yet...!", 3).show();
							
						}
					}
					else
					{
					}
					return null;
				}
				
				@Override
			      protected void onPostExecute(Void result) {
			         super.onPostExecute(result);
			         ListAdapter adapter = new SimpleAdapter(View_nearest_hospital_details.this, al,
			            R.layout.view_hsp, new String[]{ "h_name","address","place","phone","email"}, 
			            new int[]{R.id.textView7, R.id.textView8,R.id.textView9,R.id.textView10,R.id.textView11});
			         li.setAdapter(adapter);
			      }
			}
	
	
}
