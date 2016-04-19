package edu.csci153.funwithtrig;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class Calculated extends Activity {
    /** Called when the activity is first created. */
	double hSq;
	double h;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculated);
        
         TextView label1 = (TextView)findViewById(R.id.label1);
         TextView result1 = (TextView)findViewById(R.id.result1);
        
         TextView label2 = (TextView)findViewById(R.id.label2);
         TextView result2 = (TextView)findViewById(R.id.result2);
        
         TextView label3 = (TextView)findViewById(R.id.label3);
         TextView result3 = (TextView)findViewById(R.id.result3);
        
        Intent i = getIntent();
        
        double[] vals = i.getDoubleArrayExtra("ARGS");
        
        hSq = vals[1]*vals[1] + vals[2]*vals[2];    	
	 	h = Math.sqrt(hSq);

       
   	
        if(vals[0] == 0){	
        	
        	double sin = vals[2]/h;
        	label1.setText("Sin:");
        	result1.setText(Double.toString(sin));
        	
        	double cos = vals[1]/h;
        	
        	label2.setText("Cos:");
        	result2.setText(Double.toString(cos));
        	
        	double tan = vals[2]/vals[1];
        	
        	label3.setText("Tan:");
        	result3.setText(Double.toString(tan));
        
        } else if (vals[0] == 1){
        	
        	double csc = h/vals[2];
        	label1.setText("Csc:");
        	result1.setText(Double.toString(csc));
        	
        	double sec = h/vals[1];
        	label2.setText("Sec:");
        	result2.setText(Double.toString(sec));
        	
        	double cot = vals[1]/vals[2];
        	label3.setText("Cot:");
        	result3.setText(Double.toString(cot));
        	
        }
    }
}