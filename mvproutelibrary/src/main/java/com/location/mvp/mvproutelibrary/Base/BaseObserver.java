/*
 * Copyright 2018 location
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.location.mvp.mvproutelibrary.Base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.location.mvp.mvproutelibrary.error.ExceptionHandle;
import com.location.mvp.mvproutelibrary.http.INetWorkLoadingView;
import com.location.mvp.mvproutelibrary.http.RetrofitClient;
import com.location.mvp.mvproutelibrary.manager.RxManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 *
 *
 */


public abstract class BaseObserver<T> implements Observer<T> {
	private RxManager rxManager;
	private BaseView baseView;
	private INetWorkLoadingView loadingView;

	public BaseObserver(RxManager rxManager, BaseView baseView) {
		this.rxManager = rxManager;
		this.baseView = baseView;
		if (RetrofitClient.getInstance().getLoadingView() != null) {
			loadingView = RetrofitClient.getInstance().getLoadingView();
			loadingView.createLoadingView(baseView instanceof AppCompatActivity ? (AppCompatActivity) baseView : ((Fragment) baseView).getActivity());
		}
	}

	@Override
	public void onSubscribe(Disposable d) {
		rxManager.add(d);
		if (baseView instanceof BaseActivity && ((BaseActivity) baseView).isFinishing()) {
			rxManager.clear();
		} else if (loadingView != null) {
			loadingView.showLoading();
		}
	}

	@Override
	public void onError(Throwable e) {
		if (e instanceof ExceptionHandle.ResponeThrowable) {
			baseView.onshowError((ExceptionHandle.ResponeThrowable) e);
		}
		if (loadingView != null) loadingView.dismissLoading();
	}

	@Override
	public void onComplete() {
		if (loadingView != null) loadingView.dismissLoading();
	}
}
