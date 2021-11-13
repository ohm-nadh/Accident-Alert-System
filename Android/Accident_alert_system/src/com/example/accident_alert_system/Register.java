package com.example.accident_alert_system;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	EditText name,add,place,ph,mail,pass;
	Button reg,cncl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=(EditText)findViewById(R.id.editText1);
        add=(EditText)findViewById(R.id.editText2);
        place=(EditText)findViewById(R.id.editText3);
        ph=(EditText)findViewById(R.id.editText4);
        mail=(EditText)findViewById(R.id.editText5);
        pass=(EditText)findViewById(R.id.editText6);
        reg=(Button)findViewById(R.id.button1);
        cncl=(Button)findViewById(R.id.button2);
            
        reg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(!name.getText().toString().equals("")&&
				   !add.getText().toString().equals("")&&
				   !place.getText().toString().equals("")&&
				   !ph.getText().toString().equals("")&&
				   !mail.getText().toString().equals("")&&
				   !pass.getText().toString().equals("")
				   
				   )
				{
				    new savejson().execute();
				}
				else
				{

		        	 Toast.makeText(getApplicationContext(), "ALL FIELDS ARE MANDATORY", 3).show();
				}
			}
		});
        
        cncl.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }
    
    


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }
    public class savejson extends AsyncTask<Void, Void, Void>{
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			String url = "http://192.168.43.159:8000/user/android/";
			JSONObject jobj= new JSONObject();
	        try {
	   
				jobj.put("name",name.getText().toString());
				jobj.put("place", place.getText().toString());
				jobj.put("address", add.getText().toString());   
				jobj.put("phone",ph.getText().toString() );
				jobj.put("username", mail.getText().toString());
				jobj.put("password", pass.getText().toString());
				  
				
				JsonHandler.Postjson(url, jobj);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null; 
		}
		
		@Override
	      protected void onPostExecute(Void result) {
	         super.onPostExecute(result);
	    
	         
	        	 Toast.makeText(getApplicationContext(), "success", 3).show();

	        	 Intent ii=new Intent(getApplicationContext(),Login.class);
	        	 startActivity(ii);
	     
	      }
	}
	
}
