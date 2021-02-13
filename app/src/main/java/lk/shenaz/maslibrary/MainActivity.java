package lk.shenaz.maslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabCategories);


        ViewPager viewPager =(ViewPager) findViewById(R.id.ViewPager);

        MyPagerAdapter myPagerAdapter= new MyPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

}
