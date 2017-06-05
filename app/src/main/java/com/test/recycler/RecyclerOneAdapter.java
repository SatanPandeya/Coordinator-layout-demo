package com.test.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.ItemOne;

/**
 * Created by wolfmatrix on 6/5/17.
 */

public class RecyclerOneAdapter extends RecyclerView.Adapter<RecyclerOneAdapter.ViewOneHolder> {
    private Context context;
    private List<ItemOne> itemOneList = new ArrayList<>();

    public RecyclerOneAdapter(Context context, List<ItemOne> itemOneList) {
        this.context = context;
        this.itemOneList = itemOneList;
    }

    @Override
    public ViewOneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View container = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_one, parent, false);
        return new ViewOneHolder(container);
    }

    @Override
    public void onBindViewHolder(ViewOneHolder holder, int position) {
        ItemOne itemOne = itemOneList.get(position);
        holder.id.setText(String.valueOf(itemOne.getId()));
        holder.name.setText(itemOne.getName());
    }

    @Override
    public int getItemCount() {
        return itemOneList.size();
    }

    public class ViewOneHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameContentId)
        TextView id;
        @BindView(R.id.nameId)
        TextView name;

        public ViewOneHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
