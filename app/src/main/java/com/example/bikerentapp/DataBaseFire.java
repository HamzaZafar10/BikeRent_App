package com.example.bikerentapp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DataBaseFire {
    private DatabaseReference databaseReference,databaseReferenceAdmin;
    public DataBaseFire()
    {
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference("Model");
        databaseReferenceAdmin=db.getReference("Admin");
    }
    public Task<Void> add(EmailModel emailUsers)
    {
        return databaseReference.push().setValue(emailUsers);
    }
    public Task<Void> addAmin(AdminModel emailUsers)
    {
        return databaseReferenceAdmin.push().setValue(emailUsers);
    }
    public Query getData()
    {
        return databaseReference.orderByKey();
    }
}

