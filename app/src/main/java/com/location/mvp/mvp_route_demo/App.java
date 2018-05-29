package com.location.mvp.mvp_route_demo;

import android.widget.Toast;

import com.location.mvp.mvproutelibrary.Base.BaseApplication;
import com.location.mvp.mvproutelibrary.utils.SpUtils;

import java.lang.reflect.Method;

/**
 * 项目:趣租部落
 * author：田晓龙
 * time：2018/5/24 20:43
 * description：
 */

public class App extends BaseApplication {
	@Override
	public void onCreate() {
		super.onCreate();
		SpUtils.init(this);


		if (BuildConfig.DEBUG) {
			try {
				Class<?> debugDB = Class.forName("com.amitshekhar.DebugDB");
				Method getAddressLog = debugDB.getMethod("getAddressLog");
				Object value = getAddressLog.invoke(null);
				Toast.makeText(this, (String) value, Toast.LENGTH_LONG).show();
			} catch (Exception ignore) {

			}
		}
	}



}
