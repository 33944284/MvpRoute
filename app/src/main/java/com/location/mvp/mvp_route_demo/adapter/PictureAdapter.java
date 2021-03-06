package com.location.mvp.mvp_route_demo.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.location.mvp.mvp_route_demo.R;
import com.location.mvp.mvp_route_demo.bean.PictureBean;
import com.location.mvp.mvproutelibrary.adapter.BaseAdapter;
import com.location.mvp.mvproutelibrary.adapter.OnItemClickListener;
import com.location.mvp.mvproutelibrary.adapter.BaseViewHolder;
import com.location.mvp.mvproutelibrary.utils.Denutils;

import java.util.Collection;

/**
 * 项目名称: MvpRoute
 * 类描述:
 * 创建人: location
 * 创建时间: 2018/7/2 0002 20:53
 * 修改人:
 * 修改内容:
 * 修改时间:
 */


public class PictureAdapter extends BaseAdapter<PictureBean.ResultsBean,BaseViewHolder> {
	public PictureAdapter(Collection<PictureBean.ResultsBean> data, int layout, OnItemClickListener listener) {
		super(data, layout, listener);
	}

	@Override
	public void conver(BaseViewHolder holder, @Nullable PictureBean.ResultsBean data, int viewType) {
		Glide.with(holder.getContext()).load(data.getUrl())
				.centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL)
				.override(Denutils.dptopx(holder.getContext(),200),Denutils.dptopx(holder.getContext(),200))
				.thumbnail(0.1f)
				.into((ImageView) holder.findViewById(R.id
						.item_picture));
	}
}
