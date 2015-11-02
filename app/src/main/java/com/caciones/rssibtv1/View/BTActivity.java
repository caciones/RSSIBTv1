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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.caciones.rssibtv1.Controller.BTReciever;
import com.caciones.rssibtv1.Exceptions.ExceptionHandle;
import com.caciones.rssibtv1.R;
import com.caciones.rssibtv1.RO.BTDeviceRO;

import java.util.ArrayList;
import java.util.List;

public class BTActivity extends Activity {


    private static final String TAG = "activityMessage";
    private static final int REQUEST_ENABLE_BT = 1;

    public final static String BLUETOOTH_DEVICE_SELECTED = "com.caciones.rssibtv1.deviceSelected";
    //importar os btnames e os rssi de cada


    Button btnScanDevice; //botao de scan
    TextView stateBluetooth;  // estado do bt
    BluetoothAdapter bluetoothAdapter;

    List<BTDeviceRO> devicesROList;
    ArrayAdapter<BTDeviceRO>  btArrayAdapter;
    ListView devicesListView;
    BroadcastReceiver btReciever;

    BTDeviceRO selectedDevice;

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(btReciever);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bt);

        Log.i(TAG, "onCreate BT Activity");

        devicesROList = new ArrayList<>();


        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandle(this));


        btnScanDevice = (Button)findViewById(R.id.scandevice);

        stateBluetooth = (TextView)findViewById(R.id.bluetoothstate);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        devicesListView = (ListView)findViewById(R.id.devicesfound);

        btArrayAdapter = new BTArrayAdapter(this, this.devicesROList);

        devicesListView.setAdapter(btArrayAdapter);

        Log.i(TAG, "BT on and the list is ready to get the devices");

        CheckBlueToothState();

        btnScanDevice.setOnClickListener(btnScanDeviceOnClickListener);

        btReciever = new BTReciever() {
            @Override
            public void onBluetoothFound(BluetoothDevice device, int rssi) {

                Log.i(TAG, "\n_DEVICE FOUND_\n" + "Name: "+device.getName() + "\n" +"Address: "+ device.getAddress() + "\n" +"rssi: "+ rssi +" dBm");

                devicesROList.add(new BTDeviceRO(device, rssi));
                btArrayAdapter.notifyDataSetChanged();
            }
        };

        registerReceiver(btReciever, new IntentFilter(BluetoothDevice.ACTION_FOUND));
        devicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                selectedDevice = devicesROList.get(position);
                Toast.makeText(parent.getContext(), "You selected: " + selectedDevice.getBtName(),
                        Toast.LENGTH_LONG).show();
                nextScreen();


            }

        });
    }
    private void nextScreen(){
        Intent deviceSelected = new Intent(this, MeasurementsActivity.class);

        deviceSelected.putExtra(BLUETOOTH_DEVICE_SELECTED, this.selectedDevice.getAddress());
        startActivity(deviceSelected);
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

        if(requestCode == REQUEST_ENABLE_BT){
            CheckBlueToothState();
        }
    }




}



