package com.project.liverpool.utils.autocomplete;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.otaliastudios.autocomplete.RecyclerViewPresenter;
import com.project.liverpool.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsPresenter extends RecyclerViewPresenter<String> {

    @SuppressWarnings("WeakerAccess")
    protected Adapter adapter;
    private List<String> all;

    @SuppressWarnings("WeakerAccess")
    public ProductsPresenter(@NonNull Context context,List<String> all) {
        super(context);
        this.all=all;
    }

    @NonNull
    @Override
    protected PopupDimensions getPopupDimensions() {
        PopupDimensions dims = new PopupDimensions();
        dims.width = 600;
        dims.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        return dims;
    }

    @Override
    protected RecyclerView.Adapter instantiateAdapter() {
        adapter = new Adapter();
        return adapter;
    }

    @Override
    protected void onQuery(@Nullable CharSequence query) {
        if (TextUtils.isEmpty(query)) {
            adapter.setData(all);
        } else {
            query = query.toString().toLowerCase();
            List<String> list = new ArrayList<>();
            for (String u : all) {
                if (u.toLowerCase().contains(query)) {
                    list.add(u);
                }
            }
            adapter.setData(list);
            Log.e("ProductsPresenter", "found "+list.size()+" products for query "+query);
        }
        adapter.notifyDataSetChanged();
    }

    protected class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

        private List<String> data;

        @SuppressWarnings("WeakerAccess")
        protected class Holder extends RecyclerView.ViewHolder {
            private View root;
            private TextView productsName;
            Holder(View itemView) {
                super(itemView);
                root = itemView;
                productsName = itemView.findViewById(R.id.productsName);
            }
        }

        @SuppressWarnings("WeakerAccess")
        protected void setData(@Nullable List<String> data) {
            this.data = data;
        }

        @Override
        public int getItemCount() {
            return (isEmpty()) ? 1 : data.size();
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(getContext()).inflate(R.layout.item_products_auto_complete, parent, false));
        }

        private boolean isEmpty() {
            return data == null || data.isEmpty();
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            if (isEmpty()) {
                holder.productsName.setText("No se encontro producto, para auto completar!");
                holder.root.setOnClickListener(null);
                return;
            }
            final String records = data.get(position);
            holder.productsName.setText(records);
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dispatchClick(records);
                }
            });
        }
    }

}
