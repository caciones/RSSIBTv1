package com.caciones.rssibtv1.View;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.caciones.rssibtv1.Controller.BTController;
import com.caciones.rssibtv1.Controller.BTReciever;
import com.caciones.rssibtv1.R;

import java.util.ArrayList;

public class BTActivity extends ListActivity {

    private static final String TAG = "activityMessage";
    private BTController btController ;
    static final int INTENT_BT = 1;
    private ListView newDevicesListView;
    private BluetoothAdapter ba = BluetoothAdapter.getDefaultAdapter();
    //importar os btnames e os rssi de cada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);

        BTController btController = BTController.getInstance(); //tenta voltar ao broad cast recievermas com o btcontroller
                                                                // em singleton eu acho que ele so apanha uma porque
                                                                // cria varias instacias do bt controller

        IntentFilter filterAd = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        BroadcastReceiver broadcastReceiverAd = new BTReciever();
        registerReceiver(broadcastReceiverAd, filterAd);

        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        BroadcastReceiver broadcastReceiver = new MyReceiver();
        registerReceiver(broadcastReceiver, filter);

        Log.i(TAG, "onCreate BT Activity");

        this.btController.on(this);


      /* this.newDevicesListView = (ListView) findViewById(R.id.list_bt_name);

        newDevicesListView.setAdapter(mNewDevicesArrayAdapter);

        newDevicesListView.setOnItemClickListener(mDeviceClickListener);*/
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
    public void refresh(){

        if (this.ba.isDiscovering()) {
            this.ba.cancelDiscovery();
        }
        this.ba.startDiscovery();
    }


    public static void listBT(View v){

        ArrayList list = new ArrayList();

        final ArrayAdapter adapter = new BTArrayAdapter(v.getContext(), BTController.getListBTDevices());
        //lv.setAdapter(adapter);
    }
}



