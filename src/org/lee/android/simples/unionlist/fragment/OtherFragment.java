package org.lee.android.simples.unionlist.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;

import org.lee.android.simples.unionlist.R;

public class OtherFragment extends Fragment {

	@Override
	public void onInflate(Activity activity, AttributeSet attrs,
			Bundle savedInstanceState) {
		super.onInflate(activity, attrs, savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		container = (ViewGroup) inflater.inflate(
				R.layout.union_list_child_view, null);
		return container;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		View im = view.findViewById(R.id.ImageView);
		ani(im);
		bounceAnim.start();
	}

	private static final float BALL_SIZE = 600f;
	private ValueAnimator bounceAnim = null;

	private void ani(View v) {
		bounceAnim = ObjectAnimator.ofFloat(v, "y", v.getHeight() - BALL_SIZE,
				v.getY()).setDuration(1500);
		bounceAnim.setInterpolator(new BounceInterpolator());
	}

}
