package edu.csci153.funwithtrig;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class FunWithTrig extends Activity {
    /** Called when the activity is first created. */
	int choice;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText etSide1 = (EditText)findViewById(R.id.etSide1);
        final EditText etSide2 = (EditText)findViewById(R.id.etSide2);
        
        final Button btnCalc = (Button)findViewById(R.id.btnCalc);
       
        final RadioGroup rdGroup = (RadioGroup)findViewById(R.id.rdGroup);
        
        final RadioButton rdSCT = (RadioButton)findViewById(R.id.rdSCT);
        final RadioButton rdCSC = (RadioButton)findViewById(R.id.rdCSC);
        
        //final EditText etSide1 = (EditText)findViewById(R.id.etSide1);
        //final EditText etSide2 = (EditText)findViewById(R.id.etSide2);
        
        rdSCT.toggle();
        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
        	public void onCheckedChanged(RadioGroup group, int id){
        		
        		if(rdSCT.isChecked()){
        			btnCalc.setText("Sin/Cos/Tan");
        			choice = 0;
        			
        		}else if(rdCSC.isChecked()){
        			btnCalc.setText("Csc/Sec/Cot");
        			choice = 1;
        			
        		}
        		
        	}
        	
        });
        
        btnCalc.setOnClickListener(new Button.OnClickListener() {
        	public void onClick(View v){
        		
        		if( etSide1.getText().toString().equals("") ){
        			inputError();
        			etSide1.requestFocus();
        			
        		}else if(etSide2.getText().toString().equals("") ) {
        			inputError();
        			etSide2.requestFocus();
        		}
        		else{
        		openCalc(choice);
        		}
        	}
        });
        
        
       
        
    }
    
    public void inputError(){
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setCancelable(false);
    	builder.setTitle("Data Entry Error");
    	builder.setMessage("You must enter a number!");
    	
    	builder.setPositiveButton("Close", new DialogInterface.OnClickListener(){
    		public void onClick(DialogInterface dialog, int which){
    		
    			dialog.dismiss();
    		}
    	});
    	

    	AlertDialog alert = builder.create();
    	alert.show();
    	
    	
    	
    }
    
    public void openCalc(int choice){
    	
    	
    	
    	this.choice = choice;
		
    	Intent i; 
		
    	double [] vals = new double[3];
		
		vals[0] = choice; //indicates sin cos tan and 1 indicates scs, sec, 
		vals[1] = new Double(Double.parseDouble(((EditText)findViewById(R.id.etSide1)).getText().toString()));
		vals[2]= new Double(Double.parseDouble(((EditText)findViewById(R.id.etSide2)).getText().toString()));
		
		i = new Intent(this, Calculated.class);
		
		i.putExtra("ARGS", vals);
		
		startActivity(i);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
        //Determine which menu item was chosen, and act accordingly
    	
    	if(item.getItemId() == R.id.clear){
    		
    		choice = 0;
    		((EditText)findViewById(R.id.etSide1)).setText("");
    		((EditText)findViewById(R.id.etSide2)).setText("");
    	
    	}else if(item.getItemId() == R.id.calculate){	
    		if( ((EditText)findViewById(R.id.etSide1)).getText().toString().equals("") ){	
			((EditText)findViewById(R.id.etSide1)).requestFocus();
			inputError();
		}else if(((EditText)findViewById(R.id.etSide2)).getText().toString().equals("") ) {
			inputError();
			((EditText)findViewById(R.id.etSide2)).requestFocus();
		}
		else{
		openCalc(choice);
		}

    	}

        return false;
    }

}