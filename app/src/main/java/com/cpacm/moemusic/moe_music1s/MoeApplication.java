package com.cpacm.moemusic.moe_music1s;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import com.cpacm.moemusic.core.CoreApplication;
import com.cpacm.moemusic.core.bean.AccountBean;
import com.cpacm.moemusic.core.cache.SettingManager;
import com.cpacm.moemusic.core.db.dao.AccountDao;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by DIY on 2016/11/23.
 * @desciption: 应用
 */

public class MoeApplication extends CoreApplication {

    private static MoeApplication instance;

    public static MoeApplication getInstance(){
        return instance;
    }

    //运用list来保存每一个activity
    private List<Activity> mList;

    //用户信息，作为全局变量存储
    private AccountBean accountBean;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        mList=new LinkedList<>();
    }

    public AccountBean getAccountBean(){
        if(accountBean==null){
            int uid= SettingManager.getInstance().getSetting(SettingManager.ACCOUNT_ID,-1);
            AccountDao accountDao=new AccountDao();
            accountBean=accountDao.query(uid);
            accountDao.close();
        }
        return accountBean;
    }

    public void setAccountBean(AccountBean accountBean){
        this.accountBean=accountBean;
    }

    /**
     * 添加一个activity到列表中
     */
    public void addActivity(Activity activity){
        mList.add(activity);
    }

    //从列表中删除一个activity
    public void removeActivity(Activity activity){
        try{
            mList.remove(activity);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //判断是否已经运行该activity
    public boolean containActivity(Class activity){
        for(Activity act:mList){
            if(act.getClass()==activity){
                return true;
            }
        }
        return false;
    }

    //获取已经运行的Activity
    public Activity getActivity(Class activity){
        for(Activity act:mList){
            if(act.getClass()==activity){
                return act;
            }
        }
        return null;
    }

    //关闭list内的每一个activity
    public void closeAllActivity(){
        try{
            for(Activity activity:mList){
                if(activity !=null){
                    activity.finish();
                }
                mList.clear();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //获得最后打开的activity
    public Activity getCurActivity(){
        if(mList.size()>0){
            return mList.get(mList.size()-1);
        }
        return null;
    }

    //关闭list内的每一个activity并且退出应用
    public void exit(){
        closeAllActivity();
        //System.exit(0);
    }

    //获取app内存大小
    public int getMemSize(){
        return ((ActivityManager)
                getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass();
    }
}
