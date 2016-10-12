package com.fineeat;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTitles = new ArrayList<>();
    ArrayList<Integer> images = new ArrayList<>();
    Context context;

    public ViewPagerAdapter(Context con, FragmentManager fm) {
        super(fm);
        context = con;
    }

    public void addFragment(Fragment fs, String tts, int img){
        fragments.add(fs);
        tabTitles.add(tts);
        images.add(img);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Drawable image = ContextCompat.getDrawable(context, images.get(position));
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());

        SpannableString sb = new SpannableString(" ");
        ImageSpan is = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(is, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // tab with string title //return tabTitles.get(position);
        return sb;
    }
}
