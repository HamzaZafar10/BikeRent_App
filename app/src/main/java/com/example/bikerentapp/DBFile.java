package com.example.bikerentapp;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DBFile {
    DatabaseReference databaseReferenceItem,databaseReferenceBuyBikes,databaseReferenceRentBike,databaseReferenceBikeRentSudule;
    FirebaseDatabase db=FirebaseDatabase.getInstance();

    public DBFile()
    {
        databaseReferenceItem=db.getReference("Item");
        databaseReferenceBuyBikes=db.getReference("BuyBikes");
        databaseReferenceRentBike=db.getReference("RentBike");
        databaseReferenceBikeRentSudule=db.getReference("RentBikeSuhudle");
    }
    public Task<Void> addMakeUP(ItemModel Shop)
    {
        return databaseReferenceItem.push().setValue(Shop);
    }
    public Task<Void> addBike(SaleBickeModel Shop)
    {
        return databaseReferenceBuyBikes.push().setValue(Shop);
    }

    public Task<Void> RentBike(RentBikeModel Shop)
    {
        return databaseReferenceRentBike.push().setValue(Shop);
    }
    public Task<Void> RentBikeShudle(RentBikeModel Shop)
    {
        return databaseReferenceBikeRentSudule.push().setValue(Shop);
    }
    public Query getDataMakeUp()
    {
        return databaseReferenceItem.orderByKey();
    }
    public Query getBuyBikeData()
    {
        return databaseReferenceBuyBikes.orderByKey();
    }
}
