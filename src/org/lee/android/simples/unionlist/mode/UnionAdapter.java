package org.lee.android.simples.unionlist.mode;

import java.util.ArrayList;

import org.lee.android.widget.UnionView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.lee.android.simples.unionlist.R;

public class UnionAdapter extends BaseAdapter {

	private ArrayList<Unit> array;

	private Context context;

	public UnionAdapter(Context c, ArrayList<Unit> array) {
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
	public View getView(int position, View convertView, ViewGroup parent) {
		UnionView unionView = null;
		if (convertView == null) {
			unionView = new UnionView(context);
			unionView.setLoopMode(true);
			unionView.setOnItemChildClickListener(mChildEvent);
			unionView.registerClickableViews(R.id.Press);
			convertView = unionView;
		}
		unionView = (UnionView) convertView;
		unionView.attachData(getItem(position));
		return convertView;
	}

	private OnItemChildClickListener mChildEvent;

	public void setOnItemChildClickListener(OnItemChildClickListener l) {
		mChildEvent = l;
	}

	public interface OnItemChildClickListener {
		public void onItemChildClick(View view, int position,
				int childPosition, long id);
	}
}