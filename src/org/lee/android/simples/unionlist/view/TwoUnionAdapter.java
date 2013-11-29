package org.lee.android.simples.unionlist.view;

import java.util.ArrayList;

import org.lee.android.simples.unionlist.R;
import org.lee.android.simples.unionlist.mode.Bean;
import org.lee.android.simples.unionlist.mode.Unit;
import org.lee.android.widget.UnionAdapter;
import org.lee.android.widget.UnionView;

import android.content.Context;
import android.view.ViewGroup;

public class TwoUnionAdapter extends UnionAdapter {

	private ArrayList<Unit> array;

	private Context context;

	public TwoUnionAdapter(Context c, ArrayList<Unit> array) {
		context = c;
		this.array = array;
	}

	@Override
	public int getCount() {
		return array == null ? 0 : array.size();
	}

	@Override
	public Unit getItem(int position) {
		return array.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public UnionView<Bean> createUnionView() {
		UnionView<Bean> unionView = new TwoUnionView(context);
		unionView.setChildCount(3);
		unionView.orderXmlItemView(R.layout.union_list_child_view);
		unionView.setLoopMode(true);
		unionView.registerClickableViews(R.id.Press, R.id.Close);
		return unionView;
	}

	@Override
	public UnionView<?> getUnionView(int position, UnionView<?> convertView,
			ViewGroup parent) {
		TwoUnionView tu = (TwoUnionView) convertView;
		Unit unit = getItem(position);
		tu.attachData(position, unit.Children[0], unit.Children[1],
				unit.Children[2]);
		return convertView;
	}

}