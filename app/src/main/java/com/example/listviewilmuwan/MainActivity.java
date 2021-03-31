package com.example.listviewilmuwan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private IlmuwanAdapter adapter;
    private ArrayList<Ilmuwan> scientist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new IlmuwanAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, scientist.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        scientist = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Ilmuwan Ilmuwan = new Ilmuwan();
            Ilmuwan.setPhoto(dataPhoto.getResourceId(i, -1));
            Ilmuwan.setName(dataName[i]);
            Ilmuwan.setDescription(dataDescription[i]);
            scientist.add(Ilmuwan);
        }
        adapter.setscientist(scientist);
    }
}