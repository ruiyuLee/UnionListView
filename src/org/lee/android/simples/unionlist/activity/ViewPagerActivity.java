package org.lee.android.simples.unionlist.activity;

import java.util.ArrayList;

import org.lee.android.simples.unionlist.fragment.UnionListFragment;
import org.lee.android.simples.unionlist.fragment.OtherFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import org.lee.android.simples.unionlist.R;

public class ViewPagerActivity extends FragmentActivity {

	private ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);

		installView();
	}

	private void installView() {
		mPager = (ViewPager) findViewById(R.id.ViewPager);
		ArrayList<Fragment> listViews = new ArrayList<Fragment>();
		UnionListFragment a = new UnionListFragment();
		OtherFragment b = new OtherFragment();
		listViews.add(a);
		listViews.add(b);
		ViewPagerAdapter adapter = new ViewPagerAdapter(
				getSupportFragmentManager(), listViews);
		mPager.setAdapter(adapter);

	}
}

class ViewPagerAdapter extends FragmentPagerAdapter {

	private ArrayList<Fragment> mFragments;

	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public ViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
		super(fm);
		mFragments = fragments;
	}

	@Override
	public Fragment getItem(int index) {
		return mFragments.get(index);
	}

	@Override
	public int getCount() {
		return mFragments.size();
	}

}
