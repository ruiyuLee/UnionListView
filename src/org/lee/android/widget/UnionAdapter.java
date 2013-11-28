package org.lee.android.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class UnionAdapter extends BaseAdapter {

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			UnionView unionView = createUnionView();
			unionView.setOnItemChildClickListener(mChildEvent);
			convertView = unionView;
		}
		return getUnionView(position, (UnionView) convertView, parent);
	}

	/**
	 * Create a convertView. <br>
	 * call one times.
	 * 
	 * @return UnionView
	 */
	public abstract UnionView createUnionView();

	/**
	 * Get the item view.
	 * 
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 */
	public abstract UnionView getUnionView(int position, UnionView convertView,
			ViewGroup parent);

	private OnItemChildClickListener mChildEvent;

	public void setOnItemChildClickListener(
			UnionAdapter.OnItemChildClickListener l) {
		mChildEvent = l;
	}

	public interface OnItemChildClickListener {
		public void onItemChildClick(View view, int position,
				int childPosition, long id);
	}
}