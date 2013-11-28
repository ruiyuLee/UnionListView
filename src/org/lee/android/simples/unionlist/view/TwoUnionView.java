package org.lee.android.simples.unionlist.view;

import org.lee.android.widget.UnionView;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class TwoUnionView extends UnionView {

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

}
