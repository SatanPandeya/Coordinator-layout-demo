package com.test;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.test.recycler.RecyclerViewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbarId)
    Toolbar toolbar;
    @BindView(R.id.fabButtonId)
    FloatingActionButton floatingActionButton;
    private Drawer drawer;
    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        drawer = new DrawerBuilder().withActivity(this)
                .withToolbar(toolbar)
                .withHasStableIds(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("RecyclerView").withIdentifier(1).withSelectable(false)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null){
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 1){
                                intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                            }
                            if (intent != null){
                                MainActivity.this.startActivity(intent);
                            }
                        }
                        return false;
                    }
                })
                .build();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        drawer.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);
    }

    @OnClick(R.id.fabButtonId)
    public void navigateView(View view){
        startActivity(new Intent(MainActivity.this, TestActivity.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
