package com.location.mvp.mvp_route_demo.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.location.mvp.mvp_route_demo.R;
import com.location.mvp.mvp_route_demo.view.fragment.FourFragment;
import com.location.mvp.mvp_route_demo.view.fragment.OneFragment;
import com.location.mvp.mvp_route_demo.view.fragment.ThreeFragment;
import com.location.mvp.mvp_route_demo.view.fragment.TwoFragment;
import com.location.mvp.mvproutelibrary.utils.FragmentUtils;
import com.location.mvp.mvproutelibrary.utils.LogUtils;

import java.util.List;
import java.util.UUID;

/**
 * 项目:趣租部落
 *
 * @author：location time：2018/7/20 17:30
 * description：
 */

public class TestActivity extends AppCompatActivity implements View.OnClickListener {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		findViewById(R.id.id_1).setOnClickListener(this);
		findViewById(R.id.id_2).setOnClickListener(this);
		findViewById(R.id.id_3).setOnClickListener(this);
		findViewById(R.id.id_4).setOnClickListener(this);
		findViewById(R.id.test_get)
				.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {

						List<Fragment> allFragments = FragmentUtils.getInstance(TestActivity.this)
								.getAllFragments();
						for (Fragment allFragment : allFragments) {
							LogUtils.d("fragment===>"+allFragment.getClass().getSimpleName());
						}
					}
				});
	}

	@Override
	public void onClick(View v) {
		Bundle bundle = new Bundle();
		FragmentUtils instance = FragmentUtils.getInstance(this);
		FragmentUtils.FragmentWrapper start = null;
		switch (v.getId()) {
			case R.id.id_1:
				start = instance.start(OneFragment.class);
				bundle.putString("123","one");
				break;
			case R.id.id_2:
				start = instance.start(TwoFragment.class);
				start.addAnim(R.anim.left,R.anim.left);
				start.setBackGroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
				bundle.putString("123", UUID.randomUUID().toString());
				break;
			case R.id.id_3:
				start = instance.start(ThreeFragment.class);
				bundle.putString("123","three");
				break;
			case R.id.id_4:
				start = instance.start(FourFragment.class);
				bundle.putString("123","four");
				break;
			default:
		}
		start.add(R.id.test_frem)
				.setBundle(bundle)
				.commit();

	}
}
