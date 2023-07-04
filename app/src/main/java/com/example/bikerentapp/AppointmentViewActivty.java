package com.example.bikerentapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppointmentViewActivty extends AppCompatActivity {

    private TextView ProfName,Phone,Price;
    TextView Date1,time1;
    ImageView imageView;
    int check;
    AlertDialog dialog;
    int Year,Month,Day,Hr,MM;
    private TextView time9to1030;
    Button Appoint;
    String name,phone,date1,Time1;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_view_activty);
        ProfName=findViewById(R.id.NameProfessional);
        Phone=findViewById(R.id.PhoneProf);
        Price=findViewById(R.id.ProfessionalPrice);
        Date1=findViewById(R.id.Set_Date);
        time1=findViewById(R.id.Set_time);
        imageView=findViewById(R.id.imageDetalis);
        Appoint=findViewById(R.id.AppointmentBtn);

        check=0;

        String p=getIntent().getStringExtra("perPricePro");
        Phone.setText(getIntent().getStringExtra("NameBike"));
        String image=getIntent().getStringExtra("ImagePro");
        Picasso.get().load(image).into(imageView);
        Calendar calendar=Calendar.getInstance();

        name=ProfName.getText().toString();
        phone=Phone.getText().toString();

        List<RentBikeModel> models=new ArrayList<>();
        DBFile obj=new DBFile();

        Date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Year=calendar.get(Calendar.YEAR);
                Month=calendar.get(Calendar.MONTH);
                Day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog=new DatePickerDialog(AppointmentViewActivty.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        int m=month+1;
                        Date1.setText(dayOfMonth+"/"+m+"/"+year);
                        date1=Date1.getText().toString();

                    }
                },Year,Month,Day);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();
            }
        });
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        View view=getLayoutInflater().inflate(R.layout.activity_pop_up,null);
        builder.setView(view);
        dialog=builder.create();

        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView time9to1030,time1030to12,time12to130,time130to2,time2to330,time330to5,time5to630,time630to8;

                dialog.show();
                time9to1030=view.findViewById(R.id.time9to1030);
                time1030to12=view.findViewById(R.id.time1030to12);
                time12to130=view.findViewById(R.id.time12to130);
                time130to2=view.findViewById(R.id.time130to2);
                time2to330=view.findViewById(R.id.time2to330);
                time330to5=view.findViewById(R.id.time330to5);
                time5to630=view.findViewById(R.id.time5to630);
                time630to8=view.findViewById(R.id.time630to8);

                time9to1030.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time9to1030.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });
                time1030to12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time1030to12.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });
                time12to130.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time12to130.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();


                        Toast.makeText(getApplicationContext(),"javapoimt",Toast.LENGTH_SHORT);


                        Toast.makeText(AppointmentViewActivty.this, "gigi", Toast.LENGTH_SHORT).show();



                    }

                });

                time1030to12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time1030to12.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });
                time130to2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time130to2.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });
                time2to330.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time2to330.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });
                time330to5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time330to5.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });
                time5to630.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time5to630.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });
                time630to8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time1.setText(time630to8.getText().toString());
                        Time1=time1.getText().toString();

                        dialog.cancel();
                    }

                });

            }

        });

        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("please wait");
        progressDialog.setTitle("Scheduling..");
        progressDialog.setCancelable(false);

        Appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                Query query = FirebaseDatabase.getInstance().getReference("RentBikeSuhudle").
                        orderByChild("phoneNumber")
                        .equalTo(getIntent().getStringExtra("NameBike"));

                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot FatchData : snapshot.getChildren()) {
                            String DateCheck = FatchData.child("date").getValue(String.class);
                            if (DateCheck.equals(date1)) {
                                Toast.makeText(AppointmentViewActivty.this, "DateMatch", Toast.LENGTH_SHORT).show();
                                String TimeCheck = FatchData.child("time").getValue(String.class);

                                if (TimeCheck.equals(Time1)) {
                                    Toast.makeText(AppointmentViewActivty.this, "Appointment not Successfully", Toast.LENGTH_SHORT).show();
                                    check = 1;
                                    progressDialog.cancel();
                                }

                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Some Thing Wrong", Toast.LENGTH_SHORT).show();
                    }
                });
                if (check == 0) {

                    Toast.makeText(AppointmentViewActivty.this, "kk", Toast.LENGTH_SHORT).show();
                    String Pho = Phone.getText().toString();
                    String Ti = time1.getText().toString();
                    String price = Price.getText().toString();
                    name=ProfName.getText().toString();
                    Toast.makeText(AppointmentViewActivty.this, ""+name, Toast.LENGTH_SHORT).show();

                    if (name.isEmpty()|| date1.isEmpty() || Pho.isEmpty() || Ti.isEmpty() || price.isEmpty()) {
                        Toast.makeText(AppointmentViewActivty.this, "All fields Required", Toast.LENGTH_SHORT).show();
                         progressDialog.dismiss();
                    }

                    else {

                     RentBikeModel model1 = new RentBikeModel(ProfName.getText().toString(), date1, Time1, Phone.getText().toString(), Price.getText().toString(), image);
                    obj.RentBikeShudle(model1).addOnSuccessListener(suc -> {
                        Toast.makeText(getApplicationContext(), "Insertion Successfully ", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }).addOnFailureListener(er -> {
                        Toast.makeText(getApplicationContext(), er.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                    progressDialog.dismiss();
                    Toast.makeText(AppointmentViewActivty.this, "Appointed", Toast.LENGTH_SHORT).show();

                }
            }
        }
        });



    }
}
