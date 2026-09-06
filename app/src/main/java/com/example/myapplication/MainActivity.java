package com.example.myapplication;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                  // --- CRASH HANDLER ---
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            try {
                java.io.File logDir = getExternalFilesDir(null);
                java.io.File crashLog = new java.io.File(logDir, "crash.log");
                java.io.FileWriter writer = new java.io.FileWriter(crashLog, true);
                writer.write("--- CRASH REPORT: " + new java.util.Date() + " ---\n");
                throwable.printStackTrace(new java.io.PrintWriter(writer));
                writer.write("\n----------------------------------------\n");
                writer.close();
            } catch (Exception ignored) {}
            android.os.Process.killProcess(android.os.Process.myPid());
        });
        setContentView(R.layout.activity_main);

        ViewPager2 pager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tab_layout);
        pager.setAdapter(new PagerAdapter(this));
        new TabLayoutMediator(tabs, pager, (tab, pos) ->
                tab.setText("Tab " + (pos + 1))).attach();
    }

    static class PagerAdapter extends FragmentStateAdapter {
        public PagerAdapter(@NonNull FragmentActivity fa) { super(fa); }
        @NonNull @Override
        public Fragment createFragment(int position) {
            return PageFragment.newInstance(position + 1);
        }
        @Override public int getItemCount() { return 3; }
    }
}
