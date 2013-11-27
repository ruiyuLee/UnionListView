package org.lee.android.volley;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.Volley;

public class VolleyLoader {
	private static VolleyLoader mInstance = null;
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;

	private VolleyLoader(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
		mImageLoader = new ImageLoader(mRequestQueue, new BitmapCache());
	}

	public static void initialize(Context context) {
		mInstance = new VolleyLoader(context);
	}

	public static VolleyLoader getInstance() {
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		return mRequestQueue;
	}

	public ImageLoader getImageLoader() {
		return mImageLoader;
	}

	public void release() {
		this.mImageLoader = null;
		this.mRequestQueue = null;
		mInstance = null;
	}

	public class BitmapCache implements ImageCache {
		private LruCache<String, Bitmap> mCache;

		public BitmapCache() {
			int maxSize = 10 * 1024 * 1024;
			mCache = new LruCache<String, Bitmap>(maxSize) {
				@Override
				protected int sizeOf(String key, Bitmap value) {
					return value.getRowBytes() * value.getHeight();
				}

			};
		}

		@Override
		public Bitmap getBitmap(String url) {
			return mCache.get(url);
		}

		@Override
		public void putBitmap(String url, Bitmap bitmap) {
			mCache.put(url, bitmap);
		}

	}
}
