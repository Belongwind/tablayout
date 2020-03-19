package com.bliss.print.banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bliss.print.R;
import com.squareup.picasso.Picasso;

public class LocalImageHolderView extends Holder<Integer> {
    private ImageView imageView;

    public LocalImageHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        imageView = itemView.findViewById(R.id.ivPost);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    @Override
    public void updateUI(Integer data) {
        imageView.setImageResource(R.drawable.ic_default);
        Picasso.get()
                .load(data)
                .error(R.drawable.ic_default)
                .placeholder(R.drawable.ic_error)
                .fit()
                .into(imageView);
    }
}
