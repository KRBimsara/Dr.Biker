package com.bimsara.drbiker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class BookingDetailsAct extends AppCompatActivity {
    LinearLayout btn_back;
    Button btn_buy_ticket;
    TextView title_ticket, ticket_location, photo_spot, wifi_ticket, festival_ticket, short_desc_ticket;
    ImageView image_header;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);



        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        title_ticket = findViewById(R.id.title_ticket);
        ticket_location = findViewById(R.id.ticket_location);
        photo_spot = findViewById(R.id.photo_spot);
        wifi_ticket = findViewById(R.id.wifi_ticket);
        festival_ticket = findViewById(R.id.festival_ticket);
        short_desc_ticket = findViewById(R.id.short_desc_ticket);
        image_header = findViewById(R.id.image_header);
        btn_back = findViewById(R.id.btn_back);

        Bundle bundle = getIntent().getExtras();
        final String jenis_tiket_baru = bundle.getString("jenis_tiket");
        //Toast.makeText(getApplicationContext(), jenis_tiket_baru, Toast.LENGTH_SHORT).show();
        reference = FirebaseDatabase.getInstance().getReference().child("Wisata").child(jenis_tiket_baru);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoCheckout = new Intent(BookingDetailsAct.this, BookingCheckoutAct.class);
                gotoCheckout.putExtra("jenis_tiket", jenis_tiket_baru);
                startActivity(gotoCheckout);

            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtoHome = new Intent(BookingDetailsAct.this, HomeAct.class);
                startActivity(backtoHome);

            }
        });

    }
}
