package com.example.madfinal;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    String[] courses = { "Enter Hospital Id" ,
            "H1", "H2",
            "H3", "H4"};
    String[] courses1 = { "Enter Blood Group" ,
            "A+", "A-",
            "B+", "B-",
            "AB+", "AB-","O+","O-" };
    String[] courses2 = { "Enter Organ" ,
            "Eyes", "Kidney",
            "Liver", "Heart",
            "Bone Marrow" };
    EditText name1,dob1,contact1,address1;
    Button insert,update;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Spinner spino = findViewById(R.id.spinner);
        spino.setOnItemSelectedListener(this);
        Spinner spino1 = findViewById(R.id.spinner1);
        spino1.setOnItemSelectedListener(this);
        Spinner spino2 = findViewById(R.id.spinner2);
        spino2.setOnItemSelectedListener(this);
        name1=(EditText)findViewById(R.id.name1);
        dob1=(EditText)findViewById(R.id.dob1);
        contact1=(EditText)findViewById(R.id.contact1);
        address1=(EditText)findViewById(R.id.address1);
        insert=(Button) findViewById(R.id.insert);
        update=(Button) findViewById(R.id.update);
        DB = new DBHelper(this);

        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses);
        ArrayAdapter ad1
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses1);
        ArrayAdapter ad2
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                courses2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1TXT = name1.getText().toString();
                String spinoTXT = spino.getSelectedItem().toString();
                String spino1TXT = spino1.getSelectedItem().toString();
                String spino2TXT = spino2.getSelectedItem().toString();
                String dob1TXT = dob1.getText().toString();
                String contact1TXT = contact1.getText().toString();
                String address1TXT = address1.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(name1TXT,spinoTXT, spino1TXT, spino2TXT,dob1TXT,contact1TXT,address1TXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity3.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1TXT = name1.getText().toString();
                String spinoTXT = spino.getSelectedItem().toString();
                String spino1TXT = spino1.getSelectedItem().toString();
                String spino2TXT = spino2.getSelectedItem().toString();
                String dob1TXT = dob1.getText().toString();
                String contact1TXT = contact1.getText().toString();
                String address1TXT = address1.getText().toString();
                Boolean checkupdatedata = DB.updateuserdata(name1TXT,spinoTXT, spino1TXT, spino2TXT,dob1TXT,contact1TXT,address1TXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity3.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity3.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        ad1.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        ad2.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        spino.setAdapter(ad);
        spino1.setAdapter(ad1);
        spino2.setAdapter(ad2);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),
                courses[position],
                Toast.LENGTH_LONG)
                .show();
        Toast.makeText(getApplicationContext(),
                courses1[position],
                Toast.LENGTH_LONG)
                .show();
        Toast.makeText(getApplicationContext(),
                courses2[position],
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}