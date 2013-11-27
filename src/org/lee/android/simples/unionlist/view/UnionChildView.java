package org.lee.android.simples.unionlist.view;

import org.lee.android.simples.unionlist.R;
import org.lee.android.simples.unionlist.mode.Bean;
import org.lee.android.simples.unionlist.mode.UnionAdapter.OnItemChildClickListener;
import org.lee.android.volley.VolleyLoader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

public class UnionChildView extends LinearLayout {

	private NetworkImageView mImageView;
	private TextView mTitleText;
	private TextView mNumText;
	private Bean mItem;
	private int ParentPosition;
	private int ChildPosition;

	public UnionChildView(Context context, int parentPosition,
			int childPosition) {
		super(context);
		setPosition(parentPosition, childPosition);
		attachViews();
	}

	public UnionChildView(Context context, AttributeSet attrs) {
		super(context, attrs);
		attachViews();
	}

	public UnionChildView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		attachViews();
	}

	private void attachViews() {
		LayoutInflater.from(getContext()).inflate(R.layout.union_list_item,
				this);
		mImageView = (NetworkImageView) findViewById(R.id.ImageView);
		mImageView.setErrorImageResId(R.drawable.logo);
		mTitleText = (TextView) findViewById(R.id.Title);
		mNumText = (TextView) findViewById(R.id.Num);
	}

	public void setPosition(int parentPosition, int childPosition) {
		ParentPosition = parentPosition;
		this.ChildPosition = childPosition;
	}

	public int getParentPosition() {
		return ParentPosition;
	}

	public int getPosition() {
		return ChildPosition;
	}

	private OnClickListener Event = new OnClickListener() {

		@Override
		public void onClick(View v) {
			mChildEvent.onItemChildClick(v, getParentPosition(), getPosition(),
					v.getId());
		}
	};

	private OnItemChildClickListener mChildEvent;

	public void setOnItemChildClickListener(OnItemChildClickListener event) {
		mChildEvent = event;
		findViewById(R.id.Press).setOnClickListener(
				event == null ? null : Event);
	}

	public void setItem(Bean item) {
		mItem = item;
		attachToView();
	}

	private void attachToView() {
		mImageView.setImageUrl(mItem.Url, VolleyLoader.getInstance()
				.getImageLoader());
		mTitleText.setText(mItem.Title);
		mNumText.setText(mItem.Num);
	}

	public void hide() {
		setVisibility(View.INVISIBLE);
	}

	public void gone() {
		setVisibility(View.GONE);
	}

	public void visible() {
		setVisibility(View.VISIBLE);
	}

}
