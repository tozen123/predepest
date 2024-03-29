package com.doublehammerstudio.predepest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PestInformationAdapter extends RecyclerView.Adapter<PestInformationAdapter.ViewHolder> {
    private List<String> dataTitleList;
    private List<Integer> dataImageList;
    private List<String> filteredList;


    public PestInformationAdapter(List<String> dataList, List<Integer> dataImageList) {
        this.dataTitleList = dataList;
        this.dataImageList = dataImageList;
        this.filteredList = new ArrayList<>(dataList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pest_info_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textViewTitle.setText(filteredList.get(position));
        holder.imageSrc.setImageResource(dataImageList.get(position));
    }


    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageSrc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.title);
            imageSrc = itemView.findViewById(R.id.pest_image);
        }
    }

    public void filter(String query) {
        filteredList.clear();
        if (query.isEmpty()) {
            filteredList.addAll(dataTitleList);
        } else {
            for (String data : dataTitleList) {
                if (data.toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(data);
                }
            }
        }
        notifyDataSetChanged();
    }
}