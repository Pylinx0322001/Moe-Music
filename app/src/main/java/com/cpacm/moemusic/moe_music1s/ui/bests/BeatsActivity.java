package com.cpacm.moemusic.moe_music1s.ui.bests;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.cpacm.moemusic.core.bean.AccountBean;
import com.cpacm.moemusic.core.mvp.views.BeatsIView;
import com.cpacm.moemusic.moe_music1s.MoeApplication;
import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.ui.AbstractAppActivity;
import com.cpacm.moemusic.moe_music1s.ui.adapters.BeatsFragmentAdapter;
import com.cpacm.moemusic.moe_music1s.ui.widgets.CircleImageView;

public class BeatsActivity extends AbstractAppActivity
    implements NavigationView.OnNavigationItemSelectedListener,BeatsIView{

    private DrawerLayout drawerLayout;
    private BeatsPresenter beatsPresenter;
    private NavigationView navigationView;
    private CircleImageView avatar,userImg;
    private TextView nicknameTv,aboutTv;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private BeatsFragmentAdapter beatsFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_drawer_home);
        toolbar.setContentInsetsAbsolute(0, 0);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                beatsPresenter.getAccountDetail();
            }
        });

        View iconLayout=findViewById(R.id.icon_layout);
        iconLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        tabLayout=(TabLayout)findViewById(R.id.tab_layout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        beatsFragmentAdapter=new BeatsFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(beatsFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        initDrawer();
        //initData();
        getData();
        initData(MoeApplication.getInstance().getAccountBean());
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

    //private void initData(){
    private void initData(AccountBean accountBean) {
        Glide.with(this)
                .load(accountBean.getUser_avatar().getMedium())
                .placeholder(R.drawable.ic_navi_user)
                .into(userImg);
        Glide.with(this)
                .load(accountBean.getUser_avatar().getLarge())
                .placeholder(R.drawable.ic_navi_user)
                .into(avatar);
        String nickname=accountBean.getUser_nickname();
        if(TextUtils.isEmpty(nickname)){
            nickname=accountBean.getUser_name();
        }
        nicknameTv.setText(nickname);
        if(TextUtils.isEmpty(accountBean.getAbout())){
            aboutTv.setVisibility(View.GONE);
        }else{
            aboutTv.setVisibility(View.VISIBLE);
            aboutTv.setText(accountBean.getAbout());
        }
    }

    private void getData(){
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
