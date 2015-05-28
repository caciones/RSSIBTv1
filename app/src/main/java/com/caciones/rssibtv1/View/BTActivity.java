package com.caciones.rssibtv1.View;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.caciones.rssibtv1.Controller.BTController;
import com.caciones.rssibtv1.R;

public class BTActivity extends ListActivity {

    private static final String TAG = "activityMessage";

    static final int INTENT_BT = 1;
    //importar os btnames e os rssi de cada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);

        Log.i(TAG, "onCreate BT Activity");

        BTController btController = new BTController();
        btController.on(this);//erro auqi

        Log.i(TAG, "onCreate BT Activity pass");



        //List<BTDeviceRO> btDeviceROList = BTController.
        //BTArrayAdapter adapter = new BTArrayAdapter(this, values);
        //setListAdapter(adapter);*/
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, R.layout.list_bt_rssi, btController.list());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==INTENT_BT){
            if(resultCode==RESULT_OK){
                Log.i(TAG, "BT is ON");
                Toast.makeText(getApplicationContext(), "BT is ON",
                        Toast.LENGTH_SHORT).show();

            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bt, menu);
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
