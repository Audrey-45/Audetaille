package com.example.project.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class fragmentmanager extends FragmentPagerAdapter
{
    //proprieties
    private int tabno;

    /**
     * constructor
     * @param fm
     * @param behavior
     * @param tabno
     */
    public fragmentmanager(@NonNull FragmentManager fm, int behavior, int tabno) {
        super(fm, behavior);
        this.tabno = tabno;
    }

    /**
     * position good item in right place
     * @param position
     * @return
     */
    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:return new fragment1();
            case 1:return new fragment2();
            case 2:return new fragment3();
            case 3:return new fragment4();
            default:return  null;
        }
    }

    /**
     * get number fragment
     * @return
     */
    @Override
    public int getCount() {
        return tabno;
    }
}
