package org.lee.android.simples.unionlist.view;

import org.lee.android.simples.unionlist.R;
import org.lee.android.simples.unionlist.mode.Bean;
import org.lee.android.volley.VolleyLoader;
import org.lee.android.widget.UnionView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

public class TwoUnionView extends UnionView<Bean> {

	public TwoUnionView(Context context) {
		super(context);
		init();
	}

	public TwoUnionView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TwoUnionView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		setPadding(4, 4, 4, 4);
		setOrientation(LinearLayout.HORIZONTAL);
	}

	@Override
	protected void setItem(View v, Bean bean) {
		ChildViewBuffer cv = null;
		if (v.getTag() == null) {
			cv = new ChildViewBuffer(v);
			v.setTag(cv);
		}
		cv = (ChildViewBuffer) v.getTag();
		cv.setItem(bean);
	}

	private class ChildViewBuffer {

		private NetworkImageView mImageView;
		private TextView mTitleText;
		private TextView mNumText;
		private Bean mItem;

		ChildViewBuffer(View v) {
			mImageView = (NetworkImageView) v.findViewById(R.id.ImageView);
			mImageView.setErrorImageResId(R.drawable.logo);
			mTitleText = (TextView) v.findViewById(R.id.Title);
			mNumText = (TextView) v.findViewById(R.id.Num);
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

	}

}
