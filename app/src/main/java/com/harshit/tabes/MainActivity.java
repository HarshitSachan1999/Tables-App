package com.harshit.tabes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Integer> temp = new ArrayList<>();
    int timesTable;

    public void generateTable(int number){
        for(int i = 1; i<11; i++)
            temp.add(number*i);
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, temp);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar table = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);
        table.setMax(20);
        table.setProgress(1);
        table.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){}
            @Override
            public void onProgressChanged(SeekBar seekbBar, int progress, boolean fromUser){
                if(progress<1) {
                    timesTable = 1;
                    table.setProgress(1);
                }
                else {
                    timesTable = progress;
                }
                temp.clear();
                generateTable(timesTable);
            }
        });
        generateTable(1);
    }
}
