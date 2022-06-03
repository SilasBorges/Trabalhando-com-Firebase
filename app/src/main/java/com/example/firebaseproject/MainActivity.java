package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.firebaseproject.entities.Product;
import com.example.firebaseproject.entities.Users;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    Users user = new Users();
    Product product = new Product();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseReference users = reference.child("users");
        DatabaseReference products = reference.child("products");

        user.setName("Silas");
        user.setLastName("Borges");
        user.setAge(20);

        product.setDescription("Notebook");
        product.setBrand("Dell");
        product.setPrice(6.700);

        products.child("001").setValue(product);
        users.child("001").setValue(user);



    }
}