package lk.shenaz.maslibrary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    public MyPagerAdapter(@NonNull FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = new WhatsNewFragment();
        switch (position){
            case 0:
                fragment =new WhatsNewFragment();
                break;
            case 1:
                fragment =new LibraryFragment();
                break;
            case 2:
                fragment =new StoreFragment();
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
    String[] titles ={"What'sNew", "Library", "Store"};

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
