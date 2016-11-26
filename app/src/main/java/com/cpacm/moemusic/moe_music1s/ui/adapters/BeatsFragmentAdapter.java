package com.cpacm.moemusic.moe_music1s.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.cpacm.moemusic.moe_music1s.ui.album.AlbumFragment;
import com.cpacm.moemusic.moe_music1s.ui.anime.AnimeFragment;
import com.cpacm.moemusic.moe_music1s.ui.area.AreaFragment;
import com.cpacm.moemusic.moe_music1s.ui.comic.ComicFragment;
import com.cpacm.moemusic.moe_music1s.ui.radio.RadioFragment;

/**
 * Created by DIY on 2016/11/23.
 * @desciption: 主页viewpager适配器
 */

public class BeatsFragmentAdapter extends FragmentPagerAdapter {

    private AnimeFragment animeFragment;
    private AreaFragment areaFragment;
    private ComicFragment comicFragment;
    //private MusicFragment musicFragment;
    private AlbumFragment albumFragment;
    private RadioFragment radioFragment;

    private final String[] titles;

    public BeatsFragmentAdapter(FragmentManager fm){
        super(fm);
        titles=new String[]{AnimeFragment.TITLE, ComicFragment.TITLE,
                RadioFragment.TITLE,AreaFragment.TITLE
        };
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                if(animeFragment==null)
                    animeFragment=AnimeFragment.newInstance();
                return animeFragment;
            case 1:
                if(albumFragment==null)
                    albumFragment=AlbumFragment.newInstance();
                return albumFragment;
            case 2:
                if(radioFragment==null)
                    radioFragment=RadioFragment.newInstance();
                return radioFragment;
            case 3:
                if(areaFragment==null)
                    areaFragment=AreaFragment.newInstance();
                return areaFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
