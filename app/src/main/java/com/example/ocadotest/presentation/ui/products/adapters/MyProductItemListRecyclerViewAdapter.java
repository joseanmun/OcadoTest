package com.example.ocadotest.presentation.ui.products.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ocadotest.R;
import com.example.ocadotest.model.ItemModel;
import com.example.ocadotest.presentation.ui.products.fragments.ProductListFragment.OnProductListFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ItemModel} and makes a call to the
 * specified {@link OnProductListFragmentInteractionListener}.
 */
public class MyProductItemListRecyclerViewAdapter extends RecyclerView.Adapter<MyProductItemListRecyclerViewAdapter.ViewHolder> {

    private final List<ItemModel> mValues;
    private final OnProductListFragmentInteractionListener mListener;

    public MyProductItemListRecyclerViewAdapter(List<ItemModel> items, OnProductListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_productlist_itemlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mItemTitleTv.setText(holder.mItem.getTitle());
        holder.mItemPriceTv.setText(holder.context.getString(R.string.price_format, holder.mItem.getPrice()));
        Picasso.with(holder.context).load(holder.mItem.getImageUrl()).error(R.drawable.ic_error_brown_50_24dp)
                .fit().centerCrop().into(holder.mItemIv);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private final Context context;

        @BindView(R.id.item_title)
        TextView mItemTitleTv;
        @BindView(R.id.item_price)
        TextView mItemPriceTv;
        @BindView((R.id.product_iv))
        ImageView mItemIv;
        public ItemModel mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            context = view.getContext();
            mView = view;
        }

        @OnClick(R.id.item_row_ll)
        public void onItemClicked() {
            if (null != mListener) {
                mListener.onProductItemSelected(mItem.getId());
            }
        }
    }
}
