package org.lee.android.widget;

import org.lee.android.simples.unionlist.mode.Unit;
import org.lee.android.simples.unionlist.mode.UnionAdapter.OnItemChildClickListener;
import org.lee.android.simples.unionlist.view.UnionChildView;
import org.lee.android.utils.Log;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import org.lee.android.simples.unionlist.R;

public class UnionView extends LinearLayout {

	private LayoutParams param = new LayoutParams(LayoutParams.MATCH_PARENT,
			LayoutParams.MATCH_PARENT);
	private int mChildCount = 2;
	private Unit mUnit;
	private int position;
	private boolean mLoopMode = false;

	public UnionView(Context context) {
		super(context);
		init();
	}

	public UnionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs,
				R.styleable.CollectionView);
		int childViewId = a.getResourceId(R.styleable.CollectionView_childView,
				R.layout.union_list_item);
		a.recycle();
		init();
	}

	public UnionView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		setPadding(4, 4, 4, 4);
		setOrientation(LinearLayout.HORIZONTAL);
		param.weight = 1;

		attachViews();
	}

	public void setLoopMode(boolean loop) {
		mLoopMode = loop;
	}

	public Unit getUnit() {
		return mUnit;
	}

	private void attachViews() {
		for (int i = 0; i < mChildCount; i++) {
			UnionChildView itemView = new UnionChildView(getContext(),
					0, i);
			itemView.setId(i);
			addView(itemView, param);
		}
	}

	public void attachData(Unit unit) {
		mUnit = unit;
		position = unit.position;

		int length = unit.length();
		for (int i = 0; i < length; i++) {
			UnionChildView childView = (UnionChildView) getChildAt(i);
			if (unit.Children[i] == null) {
				childView.gone();
				continue;
			}
			childView.setPosition(position, i);
			childView.visible();
			childView.setItem(unit.Children[i]);
		}
	}

	private int[] mViewsIds;

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
		for (int j = 0; j < length; j++) {
			View v = view.findViewById(mViewsIds[j]);
			v.setTag(v.getId(), childPosition);
			v.setOnClickListener(ClickEvent);
		}
	}

	private OnClickListener ClickEvent = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if (mChildEvent != null) {
				int childPosition = -1;
				Object tag = v.getTag(v.getId());
				if (tag != null && tag instanceof Integer) {
					childPosition = ((Integer) tag).intValue();
				} else {
					Log.anchor("ERROR");
				}
				mChildEvent.onItemChildClick(v, position, childPosition,
						v.getId());
			}
		}
	};

	private OnItemChildClickListener mChildEvent;

	public void setOnItemChildClickListener(OnItemChildClickListener l) {
		mChildEvent = l;
	}

}
