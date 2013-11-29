package org.lee.android.widget;

import org.lee.android.widget.UnionAdapter.OnItemChildClickListener;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public abstract class UnionView<T extends Object> extends LinearLayout {

	private LayoutParams param = new LayoutParams(LayoutParams.MATCH_PARENT,
			LayoutParams.MATCH_PARENT);
	private int mChildCount = 1;
	protected int position;
	private boolean mLoopMode = false;

	public UnionView(Context context) {
		super(context);
		init();
	}

	public UnionView(Context context, int childCount) {
		super(context);
		init();
		setChildCount(childCount);
	}

	public UnionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TypedArray a = context.obtainStyledAttributes(attrs,
		// R.styleable.CollectionView);
		// a.recycle();
		init();
	}

	public UnionView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		param.weight = 1;
	}

	public void setChildCount(int childCount) {
		mChildCount = childCount;
	}

	public void orderXmlItemView(int childLayoutId) {
		attachViews(childLayoutId);
	}

	/**
	 * It's important,
	 * 
	 * @param loop
	 *            It must be true, if your item view has more(2+) child views,
	 *            and the are same. Default false.
	 */
	public void setLoopMode(boolean loop) {
		mLoopMode = loop;
	}

	private void attachViews(int layoutId) {
		for (int i = 0; i < mChildCount; i++) {
			View v = LayoutInflater.from(getContext()).inflate(layoutId, null);
			v.setId(i);
			addView(v, param);
		}
	}

	public void attachData(int position, T... beans) {
		this.position = position;

		int length = beans.length;
		for (int i = 0; i < length; i++) {
			View cv = getChildAt(i);
			if (beans[i] == null) {
				cv.setVisibility(View.GONE);
				continue;
			}
			cv.setVisibility(View.VISIBLE);
			setItem(cv, beans[i]);
		}
	}

	protected abstract void setItem(View v, T bean);

	private int[] mViewsIds;

	/**
	 * Can somebody register a callback to be invoked when this view is clicked.
	 * If this view is not clickable, it becomes clickable.
	 * 
	 * @param viewsIds
	 *            The id to register a callback for.
	 */
	public void registerClickableViews(int... viewsIds) {
		mViewsIds = viewsIds;
		attachEvent();
	}

	private boolean attachEvent() {
		if (mViewsIds == null) {
			return false;
		}
		if (mLoopMode) {
			int childCount = getChildCount();
			for (int i = 0; i < childCount; i++) {
				View loopView = getChildAt(i);
				attachEventToView(loopView, i);
			}
		} else {
			attachEventToView(this, 0);
		}
		return true;
	}

	private void attachEventToView(View view, int childPosition) {
		int length = mViewsIds.length;
		if (mLoopMode && length > 1) {
			for (int j = 0; j < length; j++) {
				View v = view.findViewById(mViewsIds[j]);
				if (v == null) {
					throw new Resources.NotFoundException(
							"Error: No resource found that matches the given name (at 'id' with value '"
									+ mViewsIds[j] + "').");
				}
				PositionInfo pi = new PositionInfo(childPosition, j);
				v.setTag(v.getId(), pi);
				v.setOnClickListener(ClickEvent);
			}
		} else {
			for (int j = 0; j < length; j++) {
				View v = view.findViewById(mViewsIds[j]);
				if (v == null) {
					throw new Resources.NotFoundException(
							"Error: No resource found that matches the given name (at 'id' with value '"
									+ mViewsIds[j] + "').");
				}
				PositionInfo pi = new PositionInfo(childPosition, -1);
				v.setTag(v.getId(), pi);
				v.setOnClickListener(ClickEvent);
			}
		}
	}

	private OnClickListener ClickEvent = new OnClickListener() {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public void onClick(View v) {
			if (mChildEvent != null) {
				PositionInfo positionInfo = new PositionInfo(-1, -1);
				Object tag = v.getTag(v.getId());
				if (tag != null && tag instanceof UnionView.PositionInfo) {
					positionInfo = ((UnionView.PositionInfo) tag);
				} else {
				}
				mChildEvent.onItemChildClick(v, position,
						positionInfo.position, positionInfo.grandchild,
						v.getId());
			}
		}
	};

	private OnItemChildClickListener mChildEvent;

	/**
	 * Register a callback to be invoked when an item in this AdapterView has
	 * been clicked.
	 * 
	 * @param listener
	 *            The callback that will be invoked.
	 */
	public void setOnItemChildClickListener(OnItemChildClickListener listener) {
		mChildEvent = listener;
	}

	private class PositionInfo {
		private int position;
		private int grandchild;

		PositionInfo(int position, int grandchild) {
			this.position = position;
			this.grandchild = grandchild;
		}
	}

}
