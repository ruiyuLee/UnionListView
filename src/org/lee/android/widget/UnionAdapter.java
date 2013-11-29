package org.lee.android.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class UnionAdapter extends BaseAdapter {

	/**
	 * It's important, but you don’t need to know that.
	 */
	@Override
	@Deprecated
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			UnionView<?> unionView = createUnionView();
			unionView.setOnItemChildClickListener(mChildEvent);
			convertView = unionView;
		}
		return getUnionView(position, (UnionView<?>) convertView, parent);
	}

	/**
	 * Create a convertView. <br>
	 * call one times.
	 * 
	 * @return UnionView
	 */
	public abstract UnionView<?> createUnionView();

	/**
	 * Get the item view.<br>
	 * Get a View that displays the data at the specified position in the data
	 * set. You can either create a View manually or inflate it from an XML
	 * layout file. When the View is inflated, the parent View (GridView,
	 * ListView...) will apply default layout parameters.
	 * 
	 * @param position
	 * @param convertView
	 * @param parent
	 * @return
	 */
	public abstract UnionView<?> getUnionView(int position,
			UnionView<?> convertView, ViewGroup parent);

	private OnItemChildClickListener mChildEvent;

	/**
	 * Register a callback to be invoked when an item in this AdapterView has
	 * been clicked.
	 * 
	 * @param listener
	 *            The callback that will be invoked.
	 */
	public void setOnItemChildClickListener(
			UnionAdapter.OnItemChildClickListener l) {
		mChildEvent = l;
	}

	/**
	 * Interface definition for a callback to be invoked when an item in this
	 * AdapterView has been clicked.
	 */
	public interface OnItemChildClickListener {
		/**
		 * Callback method to be invoked when an item in this AdapterView has
		 * been clicked.
		 * <p>
		 * Implementers can call getItemAtPosition(position) if they need to
		 * access the data associated with the selected item.
		 * 
		 * @param view
		 *            the click view.
		 * @param position
		 *            the position in ListView.
		 * @param childPosition
		 *            the position in UnionView.
		 * @param grandchild
		 *            the position in the child view for UnionView.
		 * @param id
		 */
		public void onItemChildClick(View view, int position,
				int childPosition, int grandchild, long id);
	}
}