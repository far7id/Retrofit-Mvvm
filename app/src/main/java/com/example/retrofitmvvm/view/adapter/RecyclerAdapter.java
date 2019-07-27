package com.example.retrofitmvvm.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitmvvm.R;
import com.example.retrofitmvvm.service.model.Model;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.HeroViewHolder>
{
    private Context context;
    private List<Model> resList;

    public RecyclerAdapter(Context context, List<Model> heroList)
    {
        this.context = context;
        this.resList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position)
    {
        Model model = resList.get(position);
        holder.txtId.setText(String.valueOf(model.getId()));
        holder.txtTitle.setText(model.getTitle());
    }

    @Override
    public int getItemCount()
    {
        return resList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtId;
        TextView txtTitle;

        public HeroViewHolder(View itemView)
        {
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_id_xml);
            txtTitle = itemView.findViewById(R.id.txt_title_xml);
        }
    }
}
