package com.bliss.print.banner;

import android.graphics.ImageDecoder;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.bliss.print.R;
import com.squareup.picasso.Picasso;

public class NetworkImageHolderView extends Holder<String> {
    private ImageView imageView;

    public NetworkImageHolderView(View itemView) {
        super(itemView);
    }

    @Override
    protected void initView(View itemView) {
        imageView = itemView.findViewById(R.id.ivPost);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override
    public void updateUI(String data) {
        imageView.setImageResource(R.drawable.ic_default);
        Picasso.get()
                .load(data)
//                .error(R.drawable.ic_default)
//                .placeholder(R.drawable.ic_error)
                .fit()
                .into(imageView);

    }
}
