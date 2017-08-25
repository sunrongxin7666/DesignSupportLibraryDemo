package com.android.srx.github.designsupportlibrarydemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.srx.github.designsupportlibrarydemo.fragment.TabBlankFragment;
import com.android.srx.github.designsupportlibrarydemo.utils.StringGenerator;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

	private ViewPager mViewPager;
	private TabLayout mTabLayout;
	private final int mSize = 8;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab_layout);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mTabLayout = (TabLayout) findViewById(R.id.tabs);
		initViewPager();
	}

	private void initViewPager() {
		final List<String> titles = new StringGenerator("title").generate(mSize);
		List<String> words = new StringGenerator("Fragment").generate(mSize);

		final List<Fragment> fragments = new ArrayList<>();
		for (int i = 0; i < mSize; i++) {
			TabBlankFragment fragment = new TabBlankFragment();
			fragment.setTitle(words.get(i));
			fragments.add(fragment);
		}

		//预加载
		mViewPager.setOffscreenPageLimit(titles.size()/2);

		//ViewPager滑动监听

		//设置配置器 ViewPager是ViewGroup
		mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
				return titles.get(position);
			}
		});

		//绑定
		mTabLayout.setupWithViewPager(mViewPager);

		//A去掉ActionBar的渐进阴影
		//noinspection ConstantConditions
		getSupportActionBar().setElevation(0);
	}
}
