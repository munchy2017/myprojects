package com.example.prosp.botszone.manual;

/**
 * Created by prosp on 6/10/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.prosp.botszone.R;
import com.example.prosp.botszone.clothes.Clothes;
import com.example.prosp.botszone.computers.Computers;
import com.example.prosp.botszone.estates.Estates;
import com.example.prosp.botszone.furniture.Furniture;
import com.example.prosp.botszone.jobs.Jobs;
import com.example.prosp.botszone.vehicles.Vehicles;

import java.util.Collections;
import java.util.List;

public class AdapterManual extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataManual> data = Collections.emptyList();
    DataManual current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterManual(Context context, List<DataManual> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_manual, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        final MyHolder myHolder = (MyHolder) holder;
        final DataManual current = data.get(position);
        myHolder.textFishName.setText( current.fishName);
        // myHolder.textFishName.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
//        myHolder.textSize.setText( current.sizeName);
       // myHolder.textType.setText( current.catName);
       // myHolder.textPrice.setText(current.price + "p");
       // myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        // load image into imageview using glide
        Glide.with(context).load("http://10.0.2.2/botszone/images/" + current.fishImage)
                .placeholder(R.drawable.ic_menu_camera)
                .error(R.drawable.ic_menu_camera)
                .into(myHolder.ivFish);


        myHolder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked " + current.getFishName(), Toast.LENGTH_LONG).show();
                if (position==0){
                    Intent a= new Intent(context.getApplicationContext(), Computers.class);
                    context.startActivity(a);
                }
                else if (position==1){
                    Intent b= new Intent(context.getApplicationContext(), Estates.class);
                    context.startActivity(b);
                }
                else if(position==2){
                    Intent c= new Intent(context.getApplicationContext(), Furniture.class);
                    context.startActivity(c);
                }
                else if (position==3){
                    Intent d= new Intent(context.getApplicationContext(), Clothes.class);
                    context.startActivity(d);
                }
                else if (position==4){
                    Intent e= new Intent(context.getApplicationContext(), Vehicles.class);
                    context.startActivity(e);
                }
                else if (position==5){
                    Intent f= new Intent(context.getApplicationContext(), Jobs.class);
                    context.startActivity(f);
                }

















            }





        });


    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textFishName;
        ImageView ivFish;
        TextView textSize;
        TextView textType;
        TextView textPrice;
        RelativeLayout relative;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textFishName= (TextView) itemView.findViewById(R.id.textFishName);
            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);
            //textSize = (TextView) itemView.findViewById(R.id.textSize);
            //textType = (TextView) itemView.findViewById(R.id.textType);
            //textPrice = (TextView) itemView.findViewById(R.id.textPrice);
            relative=(RelativeLayout)itemView.findViewById(R.id.relative);
        }

    }

}