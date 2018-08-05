package com.example.yashika.yombermusic;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.songs);
        } else if (position == 1) {
            return mContext.getString(R.string.albumn);
        } else {
            return mContext.getString(R.string.currently_playing);
        }
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ListFragment();
        } else if (position == 1) {
            return new GridFragment();
        } else {
            return new CurrentPlayingFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
