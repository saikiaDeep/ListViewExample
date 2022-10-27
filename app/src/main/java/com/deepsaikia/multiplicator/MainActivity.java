package com.deepsaikia.multiplicator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i!=0)
                {
                    String number=adapterView.getItemAtPosition(i).toString();
                    plotList(Integer.parseInt(number));
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
            }
        });







    }
    void plotList(int number)
    {
        ListView listView=findViewById(R.id.listView);
        ArrayList<Integer> numbers=new ArrayList<Integer>();
        numbers.add(1);
        for (int i=1;i<=100;i++)
        {
            numbers.add(i*number);

        }
        ArrayAdapter<Integer> arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,numbers);
        listView.setAdapter(arrayAdapter);
    }
}