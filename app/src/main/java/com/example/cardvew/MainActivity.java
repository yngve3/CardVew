package com.example.cardvew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerAdapter recyclerAdapter;
    private EditText editText;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerAdapter = new RecyclerAdapter();

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setReverseLayout(true);

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        editText = findViewById(R.id.EditText);

        btn = findViewById(R.id.button);

        btn.setOnClickListener(v -> {
            //Log.i("resulty", "btn");
            if (!editText.toString().isEmpty()) {
                Log.i("resulty", "btn");
                String str = editText.getText().toString();
                String[] strings = str.split(",");
                recyclerAdapter.addItem(strings[0], Integer.parseInt(strings[1]), R.drawable.ic_launcher_background);
            }
        });

    }
}