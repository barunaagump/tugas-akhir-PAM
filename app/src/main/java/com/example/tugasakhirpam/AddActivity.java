package com.example.tugasakhirpam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText judul, rating, review, murl;
    Button btnAdd,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        judul = (EditText)findViewById(R.id.txtJudul);
        rating = (EditText)findViewById(R.id.txtRating);
        review = (EditText)findViewById(R.id.txtReview);
        murl = (EditText)findViewById(R.id.txtImageUrl);

        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnBack = (Button)findViewById(R.id.btnBack);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData();
                clearAll();

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("Judul",judul.getText().toString());
        map.put("Rating",rating.getText().toString());
        map.put("Review",review.getText().toString());
        map.put("Murl",murl.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Movie").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddActivity.this, "Data Inserted Succssfully.", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        Toast.makeText(AddActivity.this, "Error While Insertion.", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll()
    {
        judul.setText("");
        rating.setText("");
        review.setText("");
        murl.setText("");
    }
}