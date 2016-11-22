package com.cpacm.moemusic.moe_music1s.ui.bests;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.cpacm.moemusic.core.bean.AccountBean;
import com.cpacm.moemusic.core.mvp.views.BeatsIView;
import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.ui.AbstractAppActivity;

public class BeatsActivity extends AbstractAppActivity
    implements NavigationView.OnNavigationItemSelectedListener,BeatsIView{

    private DrawerLayout drawerLayout;
    private BeatsPresenter beatsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_drawer_home);
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                beatsPresenter.getAccountDetail();
            }
        });
        initDrawer();
        initData();
    }

        private void initDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, R.string.open_string
                        , R.string.close_string);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        NavigationView navigationView=(NavigationView)findViewById
                (R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);
        }

    private void initData(){
        beatsPresenter=new BeatsPresenter(this);
        beatsPresenter.getAccountDetail();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.action_settings){
            return true;
        }
        if(id==android.R.id.home){
            if(drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawers();
            }else{
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void getUserFail(String msg) {
        showSnackBar(msg);
    }

    @Override
    public void setUserDetail(AccountBean accountBean) {
        showSnackBar(accountBean.getUser_name());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.nav_account){

        }else if(id==R.id.nav_free){

        }else if(id==R.id.nav_contract){

        }else if(id==R.id.nav_setting){

        }else if(id==R.id.nav_about){

        }else if(id==R.id.nav_api){

        }
        //关闭侧滑栏
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
