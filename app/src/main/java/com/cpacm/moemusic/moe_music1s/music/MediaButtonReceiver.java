package com.cpacm.moemusic.moe_music1s.music;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

/**
 * Created by DIY on 2016/11/26.
 */

public class MediaButtonReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(!Intent.ACTION_MEDIA_BUTTON.equals(intent.getAction())){
            return;
        }

        KeyEvent event=intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if(event==null || event.getAction() !=KeyEvent.ACTION_UP){
            return;
        }
    }
}
