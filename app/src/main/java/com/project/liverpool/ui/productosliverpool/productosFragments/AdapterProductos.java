package com.project.liverpool.ui.productosliverpool.productosFragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.liverpool.R;
import com.project.liverpool.data.model.Records;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<ViewHolderProductos>{

    public static final String TAG = AdapterProductos.class.getSimpleName();

    private List<Records> recordsList;
    private Context context;

    public AdapterProductos(List<Records> recordsList, Context context) {
        this.recordsList = recordsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolderProductos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ViewHolderProductos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProductos holder, int position) {
        if(recordsList != null && !recordsList.isEmpty()){

            if(recordsList.get(position).getProductDisplayName()!=null)
                holder.mItemProductBinding.tituloValue.setText(recordsList.get(position).getProductDisplayName()+"");

            if(recordsList.get(position).getListPrice() !=null)
                holder.mItemProductBinding.precioValue.setText("$ "+recordsList.get(position).getListPrice());

            if(recordsList.get(position).getSeller()!= null)
                holder.mItemProductBinding.ubicacionValue.setText(recordsList.get(position).getSeller());

            if(recordsList.get(position).getLgImage()!= null){
                //Drawable image=LoadImageFromWebOperations(recordsList.get(position).getSmImage());

                Picasso.get()
                        .load(recordsList.get(position).getLgImage())
                        .placeholder(R.drawable.ic_baseline_image_24)
                        .error(R.drawable.ic_baseline_image_24)
                        .into(holder.mItemProductBinding.imageView);
            }
        }
    }

    @Override
    public int getItemCount() {
        return recordsList == null ? 0 : recordsList.size();
    }
}
