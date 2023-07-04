package com.example.bikerentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText Email,Password;
    private Button Register;
    private FirebaseAuth auth;
    private DataBaseFire obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth=FirebaseAuth.getInstance();
        Email=findViewById(R.id.EdittextSingUp);
        Password=findViewById(R.id.EditPasswordSingUp);
        Register=findViewById(R.id.Register);

        obj=new DataBaseFire();

        ProgressDialog progressDialog=new ProgressDialog(this);
progressDialog.setTitle("Insertion...");
progressDialog.setCancelable(false);
progressDialog.setMessage("please wait");
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String test=Email.getText().toString();
                String check=test.substring(0,5);
                if(check.equals("Admin"))
                {
                    progressDialog.show();
                    Toast.makeText(getApplicationContext(), "Admin"+check, Toast.LENGTH_SHORT).show();

                    auth.createUserWithEmailAndPassword(Email.getText().toString().trim(),Password.getText().toString().trim())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful())
                                    {
                                        AdminModel adminModel=new AdminModel(Email.getText().toString().trim(),Password.getText().toString());
                                        obj.addAmin(adminModel).addOnSuccessListener(suc->{
                                            Toast.makeText(getApplicationContext(), "Insertion Successfully Admin", Toast.LENGTH_SHORT).show();

                                            Intent intent=new Intent(getApplicationContext(),SignIn.class);
                                            startActivity(intent);
                                            progressDialog.cancel();

                                        }).addOnFailureListener(er->{
                                            progressDialog.cancel();
                                            Toast.makeText(getApplicationContext(), er.getMessage(), Toast.LENGTH_SHORT).show();
                                        });

                                    }
                                    else {
                                        progressDialog.cancel();
                                        Toast.makeText(getApplicationContext(), "Failed Register user Other Email", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
                else {
                    progressDialog.show();


                    auth.createUserWithEmailAndPassword(Email.getText().toString().trim(), Password.getText().toString().trim())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        EmailModel emailUsers = new EmailModel(Email.getText().toString().trim(), Password.getText().toString());
                                        obj.add(emailUsers).addOnSuccessListener(suc -> {
                                            Toast.makeText(getApplicationContext(), "Insertion Successfully ", Toast.LENGTH_SHORT).show();
                                            Intent intent=new Intent(getApplicationContext(),SignIn.class);
                                            startActivity(intent);
                                            finishAffinity();
                                            progressDialog.cancel();

                                        }).addOnFailureListener(er -> {
                                            progressDialog.cancel();
                                            Toast.makeText(getApplicationContext(), er.getMessage(), Toast.LENGTH_SHORT).show();

                                        });

                                    } else {
                                        progressDialog.cancel();
                                        Toast.makeText(getApplicationContext(), "Failed Register user Other Email", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });


    }
}

