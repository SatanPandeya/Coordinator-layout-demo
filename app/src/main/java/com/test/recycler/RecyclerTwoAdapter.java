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
import model.ItemTwo;

/**
 * Created by wolfmatrix on 6/5/17.
 */

public class RecyclerTwoAdapter extends RecyclerView.Adapter<RecyclerTwoAdapter.ViewTwoHolder> {
    private Context context;
    private List<ItemTwo> itemTwoList = new ArrayList<>();

    public RecyclerTwoAdapter(Context context, List<ItemTwo> itemTwoList) {
        this.context = context;
        this.itemTwoList = itemTwoList;
    }

    @Override
    public ViewTwoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View containerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_two, parent, false);
        return new ViewTwoHolder(containerView);
    }

    @Override
    public void onBindViewHolder(ViewTwoHolder holder, int position) {
        ItemTwo itemTwo = itemTwoList.get(position);
        holder.id.setText(String.valueOf(itemTwo.getId()));
        holder.name.setText(itemTwo.getName());
    }

    @Override
    public int getItemCount() {
        return itemTwoList.size();
    }

    public class ViewTwoHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameContentId)
        TextView id;
        @BindView(R.id.nameId)
        TextView name;

        public ViewTwoHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
