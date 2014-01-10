package org.lee.android.simples.unionlist.view;

import org.lee.android.simples.unionlist.R;
import org.lee.android.simples.unionlist.mode.Bean;
import org.lee.android.volley.VolleyLoader;
import org.lee.android.widget.UnionView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.ImageLoader.ImageContainer;

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
	protected void onCreateItemView(View child, int position) {
		ChildViewBuffer viewHolder = new ChildViewBuffer(child);
		child.setTag(viewHolder);
	}

	@Override
	protected void setItem(View v, Bean bean) {
		ChildViewBuffer viewHolder = (ChildViewBuffer) v.getTag();
		viewHolder.setItem(bean);
	}

	private class ChildViewBuffer {

		private NetworkImageView mImageView;
		private TextView mTitleText;
		private TextView mNumText;
		private Bean mItem;
		private ImageLoader iImageLoader;
		private ImageListener iImageListener;

		ChildViewBuffer(View v) {
			mImageView = (NetworkImageView) v.findViewById(R.id.ImageView);
			mImageView.setErrorImageResId(R.drawable.logo);
			mTitleText = (TextView) v.findViewById(R.id.Title);
			mNumText = (TextView) v.findViewById(R.id.Num);
			iImageLoader = VolleyLoader.getInstance().getImageLoader();
			iImageListener = new ImageListener() {

				@Override
				public void onErrorResponse(VolleyError error) {
					Log.d("TAG", "onErrorResponse():" + error);

				}

				@Override
				public void onResponse(ImageContainer response,
						boolean isImmediate) {
					Log.d("TAG", "onResponse():" + isImmediate);

				}
			};
		}

		public void setItem(Bean item) {
			mItem = item;
			attachToView();
		}

		private void attachToView() {
			iImageLoader.get(mItem.Url, iImageListener);
			mImageView.setImageUrl(mItem.Url, iImageLoader);
			mTitleText.setText(mItem.Title);
			mNumText.setText(mItem.Num);
		}
	}

}
