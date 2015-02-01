package com.muharremtac.ab2015receiverservice;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SmsGosterici extends ActionBarActivity {

    TextView smsTextView;
    TextView phoneView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_gosterici);

        String telNo = getIntent().getStringExtra("telNo");
        String smsMesaji = getIntent().getStringExtra("smsMesaji");

        smsTextView = (TextView)findViewById(R.id.smsMessajTxt);
        phoneView = (TextView)findViewById(R.id.phoneTxt);
        smsTextView.setText(smsMesaji);
        phoneView.setText(telNo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sms_gosterici, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
