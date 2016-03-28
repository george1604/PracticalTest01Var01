package ro.pub.cs.systems.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends Activity {
	
	private EditText EditText = null;
	private Button AddButton = null;
	private Button ComputeButton = null;
	private TextView textView = null;
	private ButtonClickListener buttonClickListener = new ButtonClickListener();
	private String inputString;
	  private class ButtonClickListener implements View.OnClickListener {
	    @Override
	    public void onClick(View view) {
	    	switch(view.getId()) {
	    	case R.id.button1:
	    		String aux = EditText.getText().toString();
	    		Integer number = Integer.parseInt(aux);
	    		if(number != null) {
		    		String currentText = textView.getText().toString();
		    		if(currentText.isEmpty())
		    			textView.setText(number.toString());
		    		else
		    			textView.setText(currentText + "+" + number.toString());
	    		}
	    		break;
	    	case R.id.button2:
	    		Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01SecondaryActivity.class);
	    		intent.putExtra("stringToCompute", textView.getText().toString());
	    		startActivityForResult(intent, 1);
	    		break;
	    	}
	    }
	  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);
        AddButton = (Button)findViewById(R.id.button1);
        ComputeButton = (Button)findViewById(R.id.button2);
        EditText = (EditText)findViewById(R.id.editText1);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setText("");
        AddButton.setOnClickListener(buttonClickListener);
        ComputeButton.setOnClickListener(buttonClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_var01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	  switch(requestCode) {
    	    case 1:
    	    	Toast mytoast=new Toast(this);
	    		mytoast.setText(resultCode);
	    		mytoast.setDuration(3);
	    		mytoast.show();
    	      break;
    	  }
    	  super.onActivityResult(requestCode, resultCode, intent);
    	}
}
