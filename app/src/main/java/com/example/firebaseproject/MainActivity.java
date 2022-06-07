package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.firebaseproject.entities.Product;
import com.example.firebaseproject.entities.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private ImageView imagemPhoto;
    private Button buttonUpload;

   /* private DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth authentication = FirebaseAuth.getInstance();
    Users user = new Users();
    Product product = new Product();
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagemPhoto  = findViewById(R.id.imageFoto);
        buttonUpload = findViewById(R.id.buttonUpload);


        buttonUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagemPhoto.setDrawingCacheEnabled(true);
                imagemPhoto.buildDrawingCache();

                Bitmap bitmap = imagemPhoto.getDrawingCache();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, baos);

                byte[] imageData = baos.toByteArray();

                StorageReference storageReference = FirebaseStorage.getInstance().getReference();
                StorageReference images = storageReference.child("images");
                StorageReference imageRef = storageReference.child("celular.jpeg");

                Glide.with(MainActivity.this).load(imageRef).into( imagemPhoto);

               /* imageRef.delete().addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Erro ao deletar ", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(MainActivity.this, "Sucesso ao deletar ", Toast.LENGTH_SHORT).show();
 */
                    }
                });

                //String nameFile = UUID.randomUUID().toString();
                //StorageReference imageRef = storageReference.child("celular.jpeg");

               /* UploadTask uploadTask = imageRef.putBytes(imageData);

                uploadTask.addOnFailureListener(MainActivity.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Upload da imagem falhou: " + e.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                }).addOnSuccessListener(MainActivity.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {

                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        imageRef.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                            @Override
                            public void onComplete(@NonNull Task<Uri> task) {
                                Uri url = task.getResult();
                                Toast.makeText(MainActivity.this, "Sucesso ao fazer Upload: " + url.toString(), Toast.LENGTH_LONG).show();

                            }
                        });

                    }
                });
            /*

            }
        });

        //DatabaseReference users = reference.child("users");

        //DatabaseReference userSearch = users.child("-N3uBXR9mjCpK6WEMOSb");
        //Query userSearch = users.orderByChild("name").equalTo("Rosaine");
        //Query userSearch = users.orderByKey().limitToFirst(2);
        //Query userSearch = users.orderByKey().limitToLast(2);
        //Query userSearch = users.orderByChild("age").startAt(35);
        //Query userSearch = users.orderByChild("age").endAt(22);
        //Query userSearch = users.orderByChild("age").startAt(18).endAt(30);

        //Query userSearch = users.orderByChild("name").startAt("S").endAt("S" + "\uf8ff" );

        /*
        userSearch.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.i("Dados usuario: ", snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });*/

        /*
        user.setName("Rosaine");
        user.setLastName("Eliana");
        user.setAge(68);

        users.push().setValue(user);
            */
        //authentication.signOut();


       /* authentication.signInWithEmailAndPassword("bsilas871@gmail.com", "silas123").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){

                    Log.i("signIn", "Sucesso ao logar usuario");

                }else{

                    Log.i("signIn", "Erro ao logar usuario!");
                }
            }
        });*/

        /*
        if(authentication.getCurrentUser() != null){
            Log.i("CreateUser", "Usuario logado!");
        }
        else{
            Log.i("CreateUser", "Usuaio não logado!");
        }


         */


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
