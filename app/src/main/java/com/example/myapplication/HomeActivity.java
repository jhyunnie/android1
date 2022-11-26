package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView mypagebtn = (ImageView)findViewById(R.id.mypagebtn);
        ImageView mylocation = (ImageView)findViewById(R.id.imageView8);
        ImageView myregion = (ImageView)findViewById(R.id.imageView9);
        ImageView myregion2 = (ImageView)findViewById(R.id.imageView18);
        ImageView myattraction = (ImageView)findViewById(R.id.imageView10);
        ImageView myattraction2 = (ImageView)findViewById(R.id.imageView16);
        ImageView myboard = (ImageView)findViewById(R.id.imageView11);
        ImageView myboard2 = (ImageView)findViewById(R.id.imageView17);

        mypagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MypageActivity.class);
                startActivity(intent);
            }
        });

        mylocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),landmarkRecycle.class);
                startActivity(intent);
            }
        });

        myregion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Region.class);
                startActivity(intent);
            }
        });
        myregion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Region.class);
                startActivity(intent);
            }
        });

        myattraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Attractions.class);
                startActivity(intent);
            }
        });
        myattraction2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Attractions.class);
                startActivity(intent);
            }
        });

        myboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Board.class);
                startActivity(intent);
            }
        });

        myboard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Board.class);
                startActivity(intent);
            }
        });
    }
}