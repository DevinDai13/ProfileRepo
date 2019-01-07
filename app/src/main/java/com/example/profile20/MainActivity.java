package com.example.profile20;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    String[] nameList = new String[] {"Wing", "Sandrock", "Heavyarms", "Shenlong", "Deathscythe"};
    ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);

        ListView = (ListView) findViewById(R.id.profileListView);

        ArrayAdapter<String> names = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, nameList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.WHITE);

                // Generate ListView Item using TextView
                return view;
            }
        };

        ListView.setAdapter(names);

        // this in java always refers to the current class
        ListView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent moveToDetailIntent = new Intent(getApplicationContext(), ProfileDetailActivity.class);
        moveToDetailIntent.putExtra("ProfileName", nameList[position]);
        startActivity(moveToDetailIntent);
    }
}
