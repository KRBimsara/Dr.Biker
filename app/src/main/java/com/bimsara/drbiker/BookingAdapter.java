package com.bimsara.drbiker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyBooking> myBooking;

    public BookingAdapter(Context c, ArrayList<MyBooking> p){
        context = c;
        myBooking = p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_booking, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.xnama_wisata.setText(myBooking.get(position).getNama_wisata());
        holder.xlokasi.setText(myBooking.get(position).getLokasi());
        holder.xjumlah_tiket.setText(myBooking.get(position).getJumlah_tiket().toString() + "Services");

        final String getNama_Wisata= myBooking.get(position).getNama_wisata();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoMyTicket = new Intent(context, MyBookingAct.class);
                gotoMyTicket.putExtra("nama_wisata", getNama_Wisata);
                context.startActivity(gotoMyTicket);
            }
        });
    }

    @Override
    public int getItemCount() {

        return myBooking.size();
    }

    class  MyViewHolder extends  RecyclerView.ViewHolder{
        TextView xnama_wisata, xlokasi, xjumlah_tiket;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            xnama_wisata = itemView.findViewById(R.id.xnama_wisata);
            xlokasi = itemView.findViewById(R.id.xlokasi);
            xjumlah_tiket = itemView.findViewById(R.id.xjumlah_tiket);
        }
    }



}
