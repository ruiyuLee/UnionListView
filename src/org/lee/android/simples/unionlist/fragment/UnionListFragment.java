package org.lee.android.simples.unionlist.fragment;

import java.util.ArrayList;

import org.lee.android.simples.unionlist.mode.Bean;
import org.lee.android.simples.unionlist.mode.UnionAdapter;
import org.lee.android.simples.unionlist.mode.Unit;
import org.lee.android.simples.unionlist.mode.UnionAdapter.OnItemChildClickListener;
import org.lee.android.utils.Log;
import org.lee.data.preset.ArrayData;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.lee.android.simples.unionlist.R;

public class UnionListFragment extends Fragment {

	private UnionAdapter mAdapter;

	@Override
	public void onInflate(Activity activity, AttributeSet attrs,
			Bundle savedInstanceState) {
		super.onInflate(activity, attrs, savedInstanceState);
		Log.anchor();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.anchor();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.anchor();
	}

	private ListView listView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		container = (ViewGroup) inflater.inflate(R.layout.activity_list, null);
		listView = (ListView) container.findViewById(R.id.ListView);
		mAdapter = new UnionAdapter(getActivity(), getData());
		addOnItemChildClickListener();
		listView.setAdapter(mAdapter);
		return container;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		int ChildCount = listView.getChildCount();
		Log.anchor(ChildCount);
	}

	private ArrayList<Unit> getData() {
		String title = getResources().getString(R.string.Title);
		int length = ArrayData.arraysUrls.length - 1;
		ArrayList<Unit> array = new ArrayList<Unit>(length);
		int num = 0;
		for (int i = 0; i < length; i++) {
			if (num >= length) {
				break;
			}
			String url = ArrayData.arraysUrls[num++];
			Unit unit;
			if (i % 3 == 0) {
				Bean item1 = new Bean(title, "46万+", url);
				Bean item2 = new Bean(title, "52万+",
						ArrayData.arraysUrls[num++]);
				unit = new Unit(item1, item2);
				unit.position = i;
			} else {
				Bean item1 = new Bean(title, "38万+", url);
				unit = new Unit(item1, null);
				unit.position = i;
			}
			array.add(unit);
		}
		return array;
	}

	private void addOnItemChildClickListener() {
		mAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {

			@Override
			public void onItemChildClick(View view, int position,
					int childPosition, long id) {
				Log.anchor(position + " - " + childPosition);
			}
		});
	}
}