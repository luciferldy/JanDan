package io.luciferldy.jandan.ui.activity;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import io.luciferldy.jandan.R;
import io.luciferldy.jandan.ui.fragment.PageFragment;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String NEWS = "新鲜事";
    public static final String INTERESTING = "无聊图";
    public static final String BEAUTY = "妹纸图";
    public static final String JOKE = "段子";

    private CoordinatorLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (CoordinatorLayout) findViewById(R.id.container);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        SimpleFragmentAdapter pagerAdapter = new SimpleFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tableLayout = (TabLayout) findViewById(R.id.tab_layout);
        tableLayout.setupWithViewPager(viewPager);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.night_mode:
                        Snackbar.make(container, "夜间模式", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Snackbar.make(container, "设置", Snackbar.LENGTH_SHORT).show();
                        break;
                    default:
                        Snackbar.make(container, "默认是啥？", Snackbar.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    class SimpleFragmentAdapter extends FragmentPagerAdapter {

        private ArrayList<String> titles;

        public SimpleFragmentAdapter(FragmentManager fm) {
            super(fm);
            titles = new ArrayList<>();
            titles.add(NEWS);
            titles.add(INTERESTING);
            titles.add(BEAUTY);
            titles.add(JOKE);
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance();
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}
