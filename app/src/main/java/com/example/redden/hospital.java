package com.example.redden;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class hospital extends AppCompatActivity {
    private EditText branch;
    private EditText alternumber;
    private EditText phonenumber;
    private EditText address;
    private Button save;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();

        branch=findViewById(R.id.branchedit);
        alternumber=findViewById(R.id.alteredit);
        phonenumber=findViewById(R.id.numberedit);
        address=findViewById(R.id.addressedit);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getbranch=branch.getText().toString();
                String getalternumber=alternumber.getText().toString();
                String getphonenumber=phonenumber.getText().toString();
                String getaddress=address.getText().toString();

                HashMap<String,Object> hashMap= new HashMap();
                hashMap.put("branch",getbranch);
                hashMap.put("phonenumber",getphonenumber);
                hashMap.put("alternumber",getalternumber);
                hashMap.put("address",getaddress);

                databaseReference.child("hospital")
                        .child(getbranch)
                        .setValue(hashMap);





            }
        });
    }
}