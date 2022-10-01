package com.example.redden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class primary extends AppCompatActivity {


    private EditText  username;
    private EditText bloodgroup;
    private EditText phonenumber;
    private EditText address;
    private EditText medicalcondition;
    private EditText primarycontact;
    private EditText primarynumber;
    private Button save;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary);

        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();


        username=findViewById(R.id.edit1);
        bloodgroup=findViewById(R.id.bloodedit);
        phonenumber=findViewById(R.id.numberedit);
        address=findViewById(R.id.addressedit);
        medicalcondition=findViewById(R.id.medicaledit);
        primarycontact=findViewById(R.id.primaryedit);
        primarynumber=findViewById(R.id.contentedit);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getname=username.getText().toString();
                String getbloodgroup=bloodgroup.getText().toString();
                String getphonenumber=phonenumber.getText().toString();
                String getaddress=address.getText().toString();
                String getmedicalcondition=medicalcondition.getText().toString();
                String getprimarycontact=primarycontact.getText().toString();
                String getprimarynumber=primarycontact.getText().toString();

                HashMap<String,Object> hashMap= new HashMap();
                hashMap.put("username",getname);
                hashMap.put("phonenumber",getphonenumber);
                hashMap.put("bloodgroup",getbloodgroup);
                hashMap.put("address",getaddress);
                hashMap.put("medicalcondition",getmedicalcondition);
                hashMap.put("primarycontact",getprimarycontact);
                hashMap.put("primarynumber",getprimarynumber);

                databaseReference.child("primary")
                        .child(getname)
                        .setValue(hashMap)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {



                            }
                        });







            }
        });
    }
}
