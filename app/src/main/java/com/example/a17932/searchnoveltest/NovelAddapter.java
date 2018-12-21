package com.example.a17932.searchnoveltest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NovelAddapter extends RecyclerView.Adapter <NovelAddapter.ViewHolder> {
    private List<Novels>novelsList;

    public NovelAddapter(List<Novels> novelsList) {
        this.novelsList = novelsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.novel_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Novels novels=novelsList.get(i);
        viewHolder.novelData.setText(novels.getData());


    }


    @Override
    public int getItemCount() {
        return novelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView novelData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            novelData=itemView.findViewById(R.id.novel_data);

        }
    }
}
