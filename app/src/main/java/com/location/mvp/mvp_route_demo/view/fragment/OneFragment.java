package com.location.mvp.mvp_route_demo.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.location.mvp.mvp_route_demo.R;
import com.location.mvp.mvproutelibrary.utils.LogUtils;

/**
 * 项目:趣租部落
 *
 * @author：location time：2018/7/20 17:33
 * description：
 */

public class OneFragment extends Fragment {
	private TextView textView;

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		LogUtils.d("onAttach");
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LogUtils.d("onCreate");
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		LogUtils.d("onCreateView");
		return inflater.inflate(R.layout.fragment_text, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		LogUtils.d("onViewCreated");
		textView = view.findViewById(R.id.fragment_text);
		Bundle arguments = getArguments();
		String string = arguments.getString("123");
		textView.setText(string);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		LogUtils.d("onActivityCreated");
	}

	@Override
	public void onResume() {
		super.onResume();
		LogUtils.d("onResume");
	}

	@Override
	public void onStart() {
		super.onStart();
		LogUtils.d("onStart");
	}

	@Override
	public void onPause() {
		super.onPause();
		LogUtils.d("onPause");
	}




	@Override
	public void onStop() {
		super.onStop();
		LogUtils.d("onStop");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		LogUtils.d("onDestroyView");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		LogUtils.d("onDestroy");
	}

	@Override
	public void onDetach() {
		super.onDetach();
		LogUtils.d("onDetach");
	}

	@Override
	public void onHiddenChanged(boolean hidden) {
		super.onHiddenChanged(hidden);
		LogUtils.d("hidden===>" + hidden);
	}

}
