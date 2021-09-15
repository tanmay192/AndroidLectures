package com.example.android_lectures;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {
    Context mContext;
    List<ListItems> mList;
    LayoutInflater mLayoutInflater;

    public CustomRecyclerAdapter(Context mContext, List<ListItems> mList) {
        this.mContext = mContext;
        this.mList = mList;
        this.mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.custom_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomRecyclerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mTextView1;
        TextView mTextView2;
        ImageView mImageView1;
        ImageView mImageView2;

        ViewHolder(View itemView) {
            super(itemView);
            mTextView1 = itemView.findViewById(R.id.firstNameItem);
            mTextView2 = itemView.findViewById(R.id.lastNameItem);
            mImageView1 = itemView.findViewById(R.id.searchImage);
            mImageView2 = itemView.findViewById(R.id.deleteImage);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }
}
