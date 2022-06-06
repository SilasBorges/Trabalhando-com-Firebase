package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.firebaseproject.entities.Product;
import com.example.firebaseproject.entities.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth authentication = FirebaseAuth.getInstance();
    Users user = new Users();
    Product product = new Product();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //authentication.signOut();

       /* authentication.signInWithEmailAndPassword("bsilas871@gmail.com", "morango1").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Log.i("signIn", "Sucesso ao logar usuario");

                }else{

                    Log.i("signIn", "Erro ao logar usuario!");
                }
            }
        });*/

        if(authentication.getCurrentUser() != null){
            Log.i("CreateUser", "Usuario logado!");
        }
        else{
            Log.i("CreateUser", "Usuaio não logado!");
        }



       /* authentication.createUserWithEmailAndPassword("bsilas871@gmail.com", "morango1").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Log.i("CreateUser", "Sucesso ao criar usuario!");

                }else{

                    Log.i("CreateUser", "Erro ao criar usuario!");
                }

            }
        });*/


        /*

        DatabaseReference users = reference.child("users");
        DatabaseReference products = reference.child("products");

       users.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {
               Log.i("FIREBASE", snapshot.getValue().toString());
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });


        user.setName("Silas");
        user.setLastName("Borges");
        user.setAge(20);

        product.setDescription("Notebook");
        product.setBrand("Dell");
        product.setPrice(6.700);

        products.child("001").setValue(product);
        users.child("002").setValue(user);
        */


    }
}