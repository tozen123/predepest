package com.doublehammerstudio.predepest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataDensityAdapter extends RecyclerView.Adapter<DataDensityAdapter.ViewHolder>{
    private List<DataDensityModel> mData;
    private ItemClickListener mClickListener;

    public DataDensityAdapter(List<DataDensityModel> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_density_item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataDensityModel item = mData.get(position);
        holder.textViewDensity.setText(item.getDensityLabel());
        holder.textViewDate.setText(item.getDateLabel());
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewDensity;
        TextView textViewDate;

        ViewHolder(View itemView) {
            super(itemView);
            textViewDensity = itemView.findViewById(R.id.densityLabelTxt);
            textViewDate = itemView.findViewById(R.id.dateLabelTxt);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public DataDensityModel getItem(int id) {
        return mData.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
