package com.example.bikerentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SignIn extends AppCompatActivity {

    private EditText Email,Password;
    private Button Login;
    private TextView forget;
    private FirebaseAuth auth;
    boolean flag=false;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        auth=FirebaseAuth.getInstance();
        Email=findViewById(R.id.EdittextSingIn);
        Password=findViewById(R.id.EditPasswordSingIn);
        Login=findViewById(R.id.Login);
        forget=findViewById(R.id.forget);
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Login...");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait");
        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String user=Email.getText().toString();
                String check=user.substring(0,5);

                if(check.equals("Admin"))
                {
                    progressDialog.show();
                    Toast.makeText(getApplicationContext(), "admin", Toast.LENGTH_SHORT).show();
                    Query query= FirebaseDatabase.getInstance().getReference("Admin").
                            orderByChild("userName")
                            .equalTo(Email.getText().toString().trim());
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot FatchData:snapshot.getChildren())
                            {
                                AdminModel model=FatchData.getValue(AdminModel.class);
                                String getPassword=FatchData.child("password").getValue(String.class);
                                if(getPassword.equals(Password.getText().toString()))
                                {
                                    flag=true;
                                    Intent intent=new Intent(getApplicationContext(), AdminPanel.class);
                                    startActivity(intent);


                                }
                                else {
                                    progressDialog.cancel();
                                    Toast.makeText(getApplicationContext(), "Password is Not Match", Toast.LENGTH_SHORT).show();
                                }


                            }


                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            progressDialog.cancel();
                            Toast.makeText(getApplicationContext(), "Email Not Match use Other Email", Toast.LENGTH_SHORT).show();
                        }
                    });
                    if(flag=false)
                    {
                        Toast.makeText(SignIn.this, "No Email Matched", Toast.LENGTH_SHORT).show();
                        progressDialog.cancel();
                    }

                }
                else
                {

                    progressDialog.show();
                    Query query= FirebaseDatabase.getInstance().getReference("Model").
                            orderByChild("email")
                            .equalTo(Email.getText().toString().trim());
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot FatchData:snapshot.getChildren())
                            {
                                EmailModel model=FatchData.getValue(EmailModel.class);




                                String getPassword=FatchData.child("password").getValue(String.class);
                                if(getPassword.equals(Password.getText().toString()))
                                {
                                    Intent intent=new Intent(getApplicationContext(),MainBottomActivity.class);
                                    startActivity(intent);
                                    progressDialog.cancel();
                                }
                                else {
                                    progressDialog.cancel();
                                    Toast.makeText(getApplicationContext(), "Password is Not Match", Toast.LENGTH_SHORT).show();
                                }

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            progressDialog.cancel();
                            Toast.makeText(getApplicationContext(), "Email Not Match use Other Email", Toast.LENGTH_SHORT).show();
                        }
                    });

                }



            }
        });
        forget.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                auth.sendPasswordResetEmail(Email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if(task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Please check your Email", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "try Again Some Thing went Wrong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}