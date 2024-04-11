package com.doublehammerstudio.predepest;

import android.content.Context;
import android.content.Intent;
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
    private Context context;

    public PestInformationAdapter(Context context, List<String> dataList, List<Integer> dataImageList) {
        this.context = context;
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
        String title = dataTitleList.get(position);
        holder.textViewTitle.setText(filteredList.get(position));
        holder.imageSrc.setImageResource(dataImageList.get(position));

        // Set OnClickListener to handle item click
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle item click here
                // For example, you can start a new activity with the selected item
                Intent intent = new Intent(context, informationPestAct.class);
                intent.putExtra("title", dataTitleList.get(position)); // Pass data to the new activity if needed
                intent.putExtra("img", dataImageList.get(position)); // Pass data to the new activity if needed
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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