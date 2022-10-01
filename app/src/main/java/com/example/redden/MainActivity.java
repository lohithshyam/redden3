package com.example.redden;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {
    public FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=FirebaseFirestore.getInstance();

        Button button1 = findViewById(R.id.userlogin);
        Button button2 = findViewById(R.id.policelogin);
        Button button3 = findViewById(R.id.hospitallogin);
        Button button4 = findViewById(R.id.ambulancelogin);
        Button button5 = findViewById(R.id.primarylogin);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(MainActivity.this,user.class);
                startActivity(int1);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2=new Intent(MainActivity.this, police1 .class);
                startActivity(int2);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3=new Intent(MainActivity.this,hospital.class);
                startActivity(int3);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4=new Intent(MainActivity.this,Ambulance.class);
                startActivity(int4);

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5=new Intent(MainActivity.this,primary.class);
                startActivity(int5);

            }
        });



        }



    }



