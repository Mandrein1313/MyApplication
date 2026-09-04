package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));
        androidx.viewpager2.widget.ViewPager2 pager = findViewById(R.id.view_pager);
        com.google.android.material.tabs.TabLayout tabs = findViewById(R.id.tabs);
        pager.setAdapter(new SectionsPagerAdapter(this));
        new com.google.android.material.tabs.TabLayoutMediator(tabs, pager, (tab, position) -> {
            int res = position == 0 ? R.string.tab_text_1
                : position == 1 ? R.string.tab_text_2
                : R.string.tab_text_3;
            tab.setText(getString(res));
        }).attach();
    }
}
