package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.ViewHolder> {
    ArrayList<LandMark> items = new ArrayList<LandMark>();


    @NonNull
    @Override
    public LandmarkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_landmark, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapter.ViewHolder holder, int position) {
        LandMark item = items.get(position);
        holder.setItem(item);

        //리싸리클러뷰 클릭시 화면이동
        holder.imageLandMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mPosition = holder.getAdapterPosition();
                Context context = view.getContext();
                Intent detailActivity = new Intent(context,Gwanghwamun.class);

                detailActivity.putExtra("name",items.get(mPosition).getName());
                detailActivity.putExtra("createdBy",items.get(mPosition).getCreatedBy());
                detailActivity.putExtra("story",items.get(mPosition).getStory());
                detailActivity.putExtra("image",items.get(mPosition).getImage());
                detailActivity.putExtra("landcongestion",items.get(mPosition).getLandcongestion());
                detailActivity.putExtra("landcar",items.get(mPosition).getLandcar());
                detailActivity.putExtra("landtruck",items.get(mPosition).getLandtruck());
                detailActivity.putExtra("landperson",items.get(mPosition).getLandperson());
                detailActivity.putExtra("bustest",items.get(mPosition).getBustest());

                //시간별 혼잡도
                detailActivity.putExtra("conges9",items.get(mPosition).getConges9());
                detailActivity.putExtra("conges10",items.get(mPosition).getConges10());
                detailActivity.putExtra("conges11",items.get(mPosition).getConges11());
                detailActivity.putExtra("conges12",items.get(mPosition).getConges12());
                detailActivity.putExtra("conges13",items.get(mPosition).getConges13());
                detailActivity.putExtra("conges14",items.get(mPosition).getConges14());
                detailActivity.putExtra("conges15",items.get(mPosition).getConges15());
                detailActivity.putExtra("conges16",items.get(mPosition).getConges16());
                detailActivity.putExtra("conges17",items.get(mPosition).getConges17());
                detailActivity.putExtra("conges18",items.get(mPosition).getConges18());

                //((landmarkRecycle)context).startActivity(detailActivity);
                view.getContext().startActivity(detailActivity);

            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(LandMark item) {
        items.add(item);
    }

    public void setItems(ArrayList<LandMark> items) {
        this.items = items;
    }

    public LandMark getItem(int position) {
        return items.get(position);
    }

    public void setItem(int position, LandMark item) {
        items.set(position, item);
    }



    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageLandMark;
        TextView textName, textCreateBy ,textstory;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageLandMark = itemView.findViewById(R.id.imageLandMark);
            textName = itemView.findViewById(R.id.textName);
            textCreateBy = itemView.findViewById(R.id.textCreateBy);
            textstory = itemView.findViewById(R.id.textstory);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }

        public void setItem(LandMark item) {
            imageLandMark.setImageResource(item.image);
            textName.setText(item.name);
            textCreateBy.setText(item.createdBy);
            textstory.setText(item.story);
            ratingBar.setRating(item.rating);
        }
    }
}
