package com.izere.droidcaffeappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DonutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donut);
        TextView donutTitle = findViewById(R.id.donut_title);
        TextView donutDescription = findViewById(R.id.donut_description);

        donutTitle.setText(getIntent().getStringExtra("dTitle"));
        donutDescription.setText(getIntent().getStringExtra("dDescription"));
        ImageView donutImage = findViewById(R.id.donut_image);
        Glide.with(this).load(getIntent().getIntExtra("dImage", 0)).into(donutImage);

    }
}
