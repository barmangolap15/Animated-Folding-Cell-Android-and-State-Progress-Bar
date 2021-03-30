package com.codewithbrahim.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get our list view
        ListView theListView = findViewById(R.id.mainListView);

        // display the arraylist
        final ArrayList<Item> items = Item.getTestingList();

        // add custom btn handle to fisrt list item
        items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Custom handler for First Button", Toast.LENGTH_SHORT).show();
            }
        });

        // create custom adapter that holds element and their state
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this, items);

        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Default handler for all buttons", Toast.LENGTH_SHORT).show();
            }
        });

        // set elements to adapter
        theListView.setAdapter(adapter);

        // set click listener to the listview
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // toggle click cell state
                ((FoldingCell) view).toggle(false);

                //now register that state is selected
                adapter.registerToggle(i);
            }
        });
    }
}