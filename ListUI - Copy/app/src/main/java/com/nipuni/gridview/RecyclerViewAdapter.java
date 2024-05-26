package com.nipuni.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private ArrayList<String> names_list;
    private LayoutInflater inflater;
    itemClickListner itemClickListner;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> names_list, itemClickListner itemClickListner) {
        this.mContext = mContext;
        this.names_list = names_list;
        this.itemClickListner = itemClickListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_recyclerview, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(names_list.get(position));

        holder.itemView.setOnClickListener(view -> {
            itemClickListner.onItemClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return names_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_contact;
        TextView tv_name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            iv_contact = itemView.findViewById(R.id.iv_contact);
            tv_name = itemView.findViewById(R.id.tv_name);
        }
    }


    //create item click interface
    public interface itemClickListner{
        void onItemClick(int position);
    }
}
