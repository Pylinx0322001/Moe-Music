package com.cpacm.moemusic.moe_music1s.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

import com.cpacm.moemusic.core.utils.MoeLogger;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by DIY on 2016/11/19.
 */

public class FileManager {

    private static final int DELAY_TIME=10000;

    /**
     * 读取Assets目录下的文件
     */

    public static String getAssets(Context context,String name){
        String result=null;
        try{
            //获得AssetManager对象，调用其open方法取得对应的inputStream对象
            InputStream in=context.getAssets().open(name);
            //取得数据流的数据大小
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            result=new String(buffer);
        }catch(Exception e){
            MoeLogger.d("getAssets:"+result);
        }
        return result;
    }

    //open apk
    public static void openApk(Context context, File apk){
        Intent intent=new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(apk),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    //download apk from server
    public static File getFilefromServerToProgress(String path, FileProgress fp)
        throws Exception{
        //如果相等的话表示当前sdcard挂在在手机上并且是可用的
        if(Environment.getExternalStorageState()
                .equals(Environment.MEDIA_MOUNTED)){
            URL url=new URL(path);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setConnectTimeout(DELAY_TIME);
            int max=conn.getContentLength();
            InputStream is=conn.getInputStream();
            File file=new File(Environment.getExternalStorageDirectory(),"ifen.apk");
            FileOutputStream fos=new FileOutputStream(file);
            BufferedInputStream bis=new BufferedInputStream(is);
            byte[] buffer=new byte[1024];
            int len;
            int total=0;
            while((len=bis.read(buffer))!= -1){
                fos.write(buffer,0,len);
                total+=len;
                //获取当前下载量
                if(fp !=null)
                {
                    fp.getProgress(total,max);
                }
            }
            fos.close();
            bis.close();
            is.close();
            return file;
        }else{
            return null;
        }

    }

    public interface FileProgress{
        void getProgress(int total,int max);
    }
}
