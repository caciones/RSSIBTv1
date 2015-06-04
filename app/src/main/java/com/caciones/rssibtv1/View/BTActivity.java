package com.caciones.rssibtv1.View;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.caciones.rssibtv1.Controller.BTController;
import com.caciones.rssibtv1.Controller.BTReciever;
import com.caciones.rssibtv1.R;

public class BTActivity extends ListActivity {

    private static final String TAG = "activityMessage";
    private BTController btController = new BTController();
    static final int INTENT_BT = 1;
    //importar os btnames e os rssi de cada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);

        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        BroadcastReceiver broadcastReceiver = new BTReciever();
        registerReceiver(broadcastReceiver, filter);

        Log.i(TAG, "onCreate BT Activity");

        this.btController.on(this);
/*
        ArrayAdapter<String> list = new ArrayAdapter<String>(this, R.layout.list_bt_rssi, btController.list());
        setListAdapter(list);

        for(String s : btController.list()){
            Log.i(TAG, "BlueTooth Network " + s);
        }*/
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

    public static void getDevices(){
        Log.i(TAG, "After_BC_BT_ON");
    }
}
