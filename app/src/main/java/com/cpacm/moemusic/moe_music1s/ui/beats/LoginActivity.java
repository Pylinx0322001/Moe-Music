package com.cpacm.moemusic.moe_music1s.ui.beats;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cpacm.moemusic.moe_music1s.R;
import com.cpacm.moemusic.moe_music1s.utils.DrawableUtil;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout userLayout;
    private TextInputEditText userEditText;
    private TextInputLayout pwdLayout;
    private TextInputEditText pwdEditText;
    private Toolbar toolbar;

    //private TextInputLayout textInputLayout;
    //private TextInputEditText textInputEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


//        textInputLayout=(TextInputLayout)findViewById(R.id.user_editlayout);
//        textInputEditText=(TextInputEditText)findViewById(R.id.user_edittext);
//        textInputLayout.setHint(getString(R.string.app_name));
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //给左上角图标的左边加上一个返回的图标
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        userLayout=(TextInputLayout)findViewById(R.id.user_editlayout);
        userEditText=(TextInputEditText)findViewById(R.id.user_edittext);
        pwdLayout=(TextInputLayout)findViewById(R.id.password_editlayout);
        pwdEditText=(TextInputEditText)findViewById(R.id.password_edittext);

        //该方法返回包含控件左,上,右,下四个位置的Drawable的数组
//        Drawable[] ds=userEditText.getCompoundDrawables();
//        int r=ds[0].getBounds().right;
//        int b=ds[0].getBounds().bottom;
//        Drawable warpDrawable= DrawableUtil
//                .tintDrawable(ds[0],getResources()
//                        .getColorStateList(R.color.login_icon_colors));
//        userEditText.setCompoundDrawables(warpDrawable,ds[1],ds[2],ds[3]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();

        if(id==R.id.action_register){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
