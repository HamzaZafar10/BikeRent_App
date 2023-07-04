package com.example.bikerentapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class BikeRentInsertionFragments extends Fragment {
    private ImageView imageView;
    private EditText Title,Desc,ModelName,SalePrice;
    private Button Insert;
    private Uri uri;
    private FloatingActionButton camera;
    FirebaseStorage mStore;
    DBFile obj;
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri=data.getData();
        imageView.setImageURI(uri);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_bike_rent_insertion_fragments, container, false);
        imageView=view.findViewById(R.id.BikeImage);
        Title=view.findViewById(R.id.BikeName);
        mStore= FirebaseStorage.getInstance();
        SalePrice=view.findViewById(R.id.BikeSalePrice);
        Desc=view.findViewById(R.id.BikeDesc);
        camera=view.findViewById(R.id.BikePicImage);
        Insert=view.findViewById(R.id.BikeInsertion);
        ModelName=view.findViewById(R.id.BikeModel);

        obj=new DBFile();
        ProgressDialog progressDialog=new ProgressDialog(getContext());
        progressDialog.setTitle("Inserted..");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait");

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String Des = Desc.getText().toString();
                String RentPrice = SalePrice.getText().toString();
                String Name = Title.getText().toString();
                String Model=ModelName.getText().toString();


                if (uri == null) {
                    Toast.makeText(getContext(), "Image Not Added", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                } else if (Des.isEmpty() || RentPrice.isEmpty() || Name.isEmpty()||Model.isEmpty()) {
                    Toast.makeText(getContext(), "All Fields Required", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
                else{
                    int sale_price= Integer.parseInt(SalePrice.getText().toString());

                    StorageReference filePath = mStore.getReference().child("ImagePost").child(uri.getLastPathSegment());

                    filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getContext(), "Add one", Toast.LENGTH_SHORT).show();
                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    RentBikeModel model = new RentBikeModel(Model,RentPrice,Des,Name,task.getResult().toString());
                                    obj.RentBike(model).addOnSuccessListener(suc -> {
                                        Toast.makeText(getContext(), "Insertion Successfully ", Toast.LENGTH_SHORT).show();


                                    }).addOnFailureListener(er -> {
                                        Toast.makeText(getContext(), er.getMessage(), Toast.LENGTH_SHORT).show();
                                    });

                                }
                            });
                        }
                    });

                    progressDialog.cancel();
                }
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,45);
            }
        });
        return view;

    }
}