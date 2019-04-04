package com.example.prosp.botszone.clothes;

/**
 * Created by prosp on 7/23/2018.
 */


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.prosp.botszone.R;

import java.util.Collections;
import java.util.List;

public class AdapterClothes extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<DataClothes> data = Collections.emptyList();
    DataClothes current;
    int currentPos = 0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterClothes(Context context, List<DataClothes> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.container_fish, parent, false);
        com.example.prosp.botszone.clothes.AdapterClothes.MyHolder holder = new com.example.prosp.botszone.clothes.AdapterClothes.MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        final com.example.prosp.botszone.clothes.AdapterClothes.MyHolder myHolder = (com.example.prosp.botszone.clothes.AdapterClothes.MyHolder) holder;
        final DataClothes current = data.get(position);
        myHolder.textFishName.setText( current.fishName);
        // myHolder.textFishName.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        myHolder.textSize.setText( current.sizeName);
        myHolder.textType.setText( current.catName);
        myHolder.textPrice.setText(current.price + "p");
        myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

        // load image into imageview using glide
        Glide.with(context).load("http://10.0.2.2/botszone/images/" + current.fishImage)
                .placeholder(R.drawable.ic_menu_camera)
                .error(R.drawable.ic_menu_camera)
                .into(myHolder.ivFish);


        myHolder.relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "you clicked " + current.getPrice(), Toast.LENGTH_LONG).show();


                //setting a dialog
                LayoutInflater li = LayoutInflater.from(context);
                View dialogView = li.inflate(R.layout.dialog, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                //setting dialog title

                alertDialogBuilder.setTitle("Product Details");
                // alertDialogBuilder.setIcon(R.drawable.icon);
                alertDialogBuilder.setView(dialogView);

                ImageView image = (ImageView) dialogView.findViewById(R.id.ivFish);
                TextView title = (TextView) dialogView.findViewById(R.id.textFishName);
                TextView shortdesc = (TextView) dialogView.findViewById(R.id.textSize);
                TextView rating1 = (TextView) dialogView.findViewById(R.id.textType);
                TextView price = (TextView) dialogView.findViewById(R.id.textPrice);
                ImageButton cal = (ImageButton) dialogView.findViewById(R.id.imageButton);
                ImageButton app= (ImageButton) dialogView.findViewById(R.id.imageButton2);
                ImageButton site=(ImageButton) dialogView.findViewById(R.id.imageButton3) ;

                // load image into imageview using glide

                Glide.with(context).load("http://10.0.2.2/botszone/images/" + current.getImage()).into(image);
                title.setText(current.getFishName());
                shortdesc.setText(current.getCatName());
                rating1.setText(current.getSizeName());
                price.setText(String.valueOf(current.getPrice()));


                cal.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        String temp = "tel:" + "0775688386";
                        intent.setData(Uri.parse(temp));


                        context.startActivity(intent);
                    }
                });

                app.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Uri uri = Uri.parse("smsto:" + "+263775688386");
                        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                        sendIntent.setPackage("com.whatsapp");
                        context.startActivity(sendIntent);
                    }
                });

                site.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Uri uri = Uri.parse("http://" + current.getPrice()); // missing 'http://' will cause crashed
                        Uri uri= Uri.parse("http://protech.co.zw");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);

                    }
                });







                alertDialogBuilder
                        .setCancelable(false)
                       /* .setPositiveButton("More Info", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //Uri uri = Uri.parse("http://" + current.getPrice()); // missing 'http://' will cause crashed
                                // Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                //  context.startActivity(intent);

                            }
                        })*/



                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

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
            textSize = (TextView) itemView.findViewById(R.id.textSize);
            textType = (TextView) itemView.findViewById(R.id.textType);
            textPrice = (TextView) itemView.findViewById(R.id.textPrice);
            relative=(RelativeLayout)itemView.findViewById(R.id.relative);
        }

    }

}