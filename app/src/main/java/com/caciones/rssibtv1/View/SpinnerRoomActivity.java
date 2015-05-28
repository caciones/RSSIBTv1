package com.caciones.rssibtv1.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.caciones.rssibtv1.Controller.RoomController;
import com.caciones.rssibtv1.R;

import java.util.List;

/**
 * Created by Lenovo on 27/05/2015.

 */
public class SpinnerRoomActivity extends ActionBarActivity implements AdapterView.OnItemSelectedListener{

    //info sobre o estado da actividade
    private static final String TAG = "activity_2_Message";

        // Spinner element
        Spinner spinner;

        // Add button
        Button btnAdd;
        Button btnDelete;
        Button btnNext;


        // Input text
        EditText inputLabel;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.room_sceen);

            // Spinner element
            spinner = (Spinner) findViewById(R.id.spinner_room);

            // add button
            btnAdd = (Button) findViewById(R.id.btn_add_room);
            btnDelete = (Button) findViewById(R.id.btn_delete_room);
            btnNext = (Button) findViewById(R.id.btn_next_room);

            // new label input field
            //inputLabel = (EditText) findViewById(R.id.input_label);
            Log.i(TAG, "ver se chega ao spinner");
            // Spinner click listener
            spinner.setOnItemSelectedListener(this);

            // Loading spinner data from database
            loadSpinnerData();

            /**
             * Add new label button click listener
             * */
            btnAdd.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    String label = inputLabel.getText().toString();

                    if (label.trim().length() > 0) {


                        // making input filed text to blank
                        inputLabel.setText("");

                        // Hiding the keyboard
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);

                        // loading spinner with newly added data
                        loadSpinnerData();
                    } else {
                        Toast.makeText(getApplicationContext(), "Please enter building",
                                Toast.LENGTH_SHORT).show();
                    }

                }
            });

            Log.i(TAG, "onCreate_2");
        }

        /**
         * Function to load the spinner data
         * */
        private void loadSpinnerData() {


            // Chamar o building da spinnerbuilding para aqui
            Intent intent = getIntent();

            Bundle extras = intent.getExtras();
            String buildingName = extras.getString("buildingNameExtra");


            // Spinner Drop down elements -  fazer o bundle no spinnerbuilding para passar a string para aqui

            List<String> lables = RoomController.loadAllRooms(buildingName);

            // Creating adapter for spinner
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, lables);

            // Drop down layout style - list view with radio button
            dataAdapter
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            // attaching data adapter to spinner
            spinner.setAdapter(dataAdapter);
        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position,
                                   long id) {
            // On selecting a spinner item
            String label = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "You selected: " + label,
                    Toast.LENGTH_LONG).show();

        }




        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }
    }



