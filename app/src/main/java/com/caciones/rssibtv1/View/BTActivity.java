package com.caciones.rssibtv1.View;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.caciones.rssibtv1.Controller.BTReciever;
import com.caciones.rssibtv1.Exceptions.ExceptionHandle;
import com.caciones.rssibtv1.R;

import java.util.ArrayList;

public class BTActivity extends Activity {

    private static final String TAG = "activityMessage";
    private static final int REQUEST_ENABLE_BT = 1;
    //importar os btnames e os rssi de cada


    Button btnScanDevice; //botao de scan
    TextView stateBluetooth;  // estado do bt
    BluetoothAdapter bluetoothAdapter;

    ArrayList<String> listFoundDevices;
    ArrayAdapter<String>  btArrayAdapter;
    ListView listDevicesFound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);

        Log.i(TAG, "onCreate BT Activity");



        listFoundDevices = new ArrayList<String>();


        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandle(this));

        setContentView(R.layout.activity_bt);

        btnScanDevice = (Button)findViewById(R.id.scandevice);

        stateBluetooth = (TextView)findViewById(R.id.bluetoothstate);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        listDevicesFound = (ListView)findViewById(R.id.devicesfound);

        btArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.listFoundDevices);

        listDevicesFound.setAdapter(btArrayAdapter);

        Log.i(TAG, "BT on and the list is ready to get the devices");

        CheckBlueToothState();

        btnScanDevice.setOnClickListener(btnScanDeviceOnClickListener);

        BroadcastReceiver btReciever = new BTReciever() {
            @Override
            public void onBluetoothFound(BluetoothDevice device, int rssi) {

                Log.i(TAG, "device found\n" + "Name: "+device.getName() + "\n" +"Address: "+ device.getAddress() + "\n" +"rssi: "+ rssi +" dBm");

                listFoundDevices.add("Name: "+device.getName() + "\n" +"Address: "+ device.getAddress() + "\n" +"rssi: "+ rssi +" dBm");
            }
        };

        registerReceiver(btReciever, new IntentFilter(BluetoothDevice.ACTION_FOUND));

    }

    private Button.OnClickListener btnScanDeviceOnClickListener
            = new Button.OnClickListener(){

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            Log.i(TAG, "scanning for BT{}" + bluetoothAdapter.getName());
            //btArrayAdapter.clear();
            bluetoothAdapter.startDiscovery();
        }};

    private void CheckBlueToothState(){
        if (bluetoothAdapter == null){
            stateBluetooth.setText("Bluetooth NOT support");
        }else{
            if (bluetoothAdapter.isEnabled()){
                if(bluetoothAdapter.isDiscovering()){
                    stateBluetooth.setText("Bluetooth is currently in device discovery process.");
                }else{
                    stateBluetooth.setText("Bluetooth is Enabled.");
                    btnScanDevice.setEnabled(true);
                }
            }else{
                stateBluetooth.setText("Bluetooth is NOT Enabled!");
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        if(requestCode == REQUEST_ENABLE_BT){
            CheckBlueToothState();
        }
    }


}



