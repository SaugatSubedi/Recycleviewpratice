package com.saugat.recycleviewpratice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetails extends AppCompatActivity {

    ImageView imageProfile;
    TextView tvName, tvMessage, tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        imageProfile = findViewById(R.id.imageProfile);
        tvName= findViewById(R.id.textName);
        tvMessage= findViewById(R.id.textMessage);
        tvTime = findViewById(R.id.textTime);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            imageProfile.setImageResource(bundle.getInt("image"));
            tvName.setText(bundle.getString("name"));
            tvMessage.setText(bundle.getString("message"));
            tvTime.setText(bundle.getString("time"));
        }

    }
}
