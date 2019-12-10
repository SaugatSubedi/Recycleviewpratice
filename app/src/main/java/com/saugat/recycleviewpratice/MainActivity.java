package com.saugat.recycleviewpratice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("Deepak Maharjan", "Oiii bahun k gardai chhas!", "20:20", R.drawable.deepak));
        contactsList.add(new Contacts("Devish Chhetri", "Khana khais?!", "20:15", R.drawable.devish));
        contactsList.add(new Contacts("Anish Thakur", "Home Work garis?", "20:14", R.drawable.anish));
        contactsList.add(new Contacts("Ankit Nemkul", "Gana chha?", "20:10", R.drawable.ankit));
        contactsList.add(new Contacts("Shubam Shrestha", "oie aja betni ho!", "20:05", R.drawable.shubham));
        contactsList.add(new Contacts("Poojan Thapa", "Mobile leegnds hanna aau raaja!", "20:01", R.drawable.poozan));

        ContactsAdapter contactsAdapter = new ContactsAdapter(this, contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
