package com.project.liverpool.ui.productosliverpool.productosFragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.project.liverpool.R;
import com.project.liverpool.databinding.ItemProductBinding;

public class ViewHolderProductos extends RecyclerView.ViewHolder implements View.OnClickListener{

    ItemProductBinding mItemProductBinding;

    public ViewHolderProductos(View itemView) {
        super(itemView);
        mItemProductBinding = ItemProductBinding.bind(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
