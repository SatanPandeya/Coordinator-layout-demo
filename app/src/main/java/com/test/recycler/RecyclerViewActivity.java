package com.test.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import model.ItemOne;
import model.ItemTwo;

/**
 * Created by wolfmatrix on 6/5/17.
 */

public class RecyclerViewActivity extends AppCompatActivity {
    @BindView(R.id.recyclerOneId)
    RecyclerView recyclerViewOne;
    @BindView(R.id.recyclerTwoId)
    RecyclerView recyclerViewTwo;

    private RecyclerOneAdapter recyclerOneAdapter;
    private RecyclerTwoAdapter recyclerTwoAdapter;
    private List<ItemOne> itemOneList = new ArrayList<>();
    private List<ItemTwo> itemTwoList = new ArrayList<>();
    private StaggeredGridLayoutManager staggeredGridLayoutManagerOne;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

        staggeredGridLayoutManagerOne = new StaggeredGridLayoutManager(2, 1);
        recyclerOneAdapter = new RecyclerOneAdapter(this, itemOneList);
        recyclerViewOne.setLayoutManager(staggeredGridLayoutManagerOne);
        recyclerViewOne.setAdapter(recyclerOneAdapter);

        recyclerTwoAdapter = new RecyclerTwoAdapter(this, itemTwoList);
        recyclerViewTwo.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL));
        recyclerViewTwo.setAdapter(recyclerTwoAdapter);

        prepareListOne();
        prepareListTwo();

    }

    private void prepareListOne() {
        ItemOne itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);

        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        itemOne = new ItemOne(1, "Satan");
        itemOneList.add(itemOne);
        recyclerOneAdapter.notifyDataSetChanged();
    }

    private void prepareListTwo() {
        ItemTwo itemTwo = new ItemTwo(2, "Pandeya");
        itemTwoList.add(itemTwo);
        itemTwo = new ItemTwo(2, "Pandeya");
        itemTwoList.add(itemTwo);
        itemTwo = new ItemTwo(2, "Pandeya");
        itemTwoList.add(itemTwo);
        itemTwo = new ItemTwo(2, "Pandeya");
        itemTwoList.add(itemTwo);
        itemTwo = new ItemTwo(2, "Pandeya");
        itemTwoList.add(itemTwo);
        itemTwo = new ItemTwo(2, "Pandeya");
        itemTwoList.add(itemTwo);
        recyclerTwoAdapter.notifyDataSetChanged();
    }
}
