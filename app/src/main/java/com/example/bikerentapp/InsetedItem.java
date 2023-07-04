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

public class InsetedItem extends Fragment {
    private ImageView imageView;
    private EditText Title,Desc,Dicount,SalePrice;
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

         View view= inflater.inflate(R.layout.fragment_inseted_item, container, false);

        imageView=view.findViewById(R.id.profile_image_ShopM);
        Title=view.findViewById(R.id.TileProductShopM);

        mStore=FirebaseStorage.getInstance();
        SalePrice=view.findViewById(R.id.SalePriceShopM);
        Desc=view.findViewById(R.id.descShopM);
        camera=view.findViewById(R.id.camaraM);
        Insert=view.findViewById(R.id.SubmitM);
        obj=new DBFile();
      ProgressDialog  progressDialog=new ProgressDialog(getContext());
        progressDialog.setTitle("Inserted..");
        progressDialog.setCancelable(false);
        progressDialog.setMessage("please wait");

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String Des = Desc.getText().toString();
                String Sale = SalePrice.getText().toString();
                String Name = Title.getText().toString();

                if (uri == null) {
                    Toast.makeText(getContext(), "Image Not Added", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                } else if (Des.isEmpty() || Sale.isEmpty() || Name.isEmpty()) {
                    Toast.makeText(getContext(), "All Fields Required", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
                }
                else{


                    String name = Title.getText().toString();
                    String de = Desc.getText().toString();
                    int sale_price= Integer.parseInt(SalePrice.getText().toString());

                    StorageReference filePath = mStore.getReference().child("ImagePost").child(uri.getLastPathSegment());

                    filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(getContext(), "Add one", Toast.LENGTH_SHORT).show();
                            Task<Uri> downloadUrl = taskSnapshot.getStorage().getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                                @Override
                                public void onComplete(@NonNull Task<Uri> task) {
                                    ItemModel model = new ItemModel(task.getResult().toString(), name, de, sale_price);
                                    Toast.makeText(getContext(), "" + model.getPrice(), Toast.LENGTH_SHORT).show();
                                    obj.addMakeUP(model).addOnSuccessListener(suc -> {
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