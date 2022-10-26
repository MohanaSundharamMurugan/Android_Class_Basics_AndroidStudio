package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity
{
    GridView itemsGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        itemsGrid=(GridView)findViewById(R.id.itemsGV);

        ArrayList<ItemModel> courseModelArrayList = new ArrayList<ItemModel>();

        courseModelArrayList.add(new ItemModel("JAVA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("C++", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("Python", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("Javascript", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));
        courseModelArrayList.add(new ItemModel("DSA", R.drawable.ic_launcher_background));

        GridViewAdapter adapter = new GridViewAdapter(this, courseModelArrayList);
        itemsGrid.setAdapter(adapter);

        itemsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ItemModel value = adapter.getItem(i);
                Toast.makeText(getApplicationContext(), value.getItem_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}