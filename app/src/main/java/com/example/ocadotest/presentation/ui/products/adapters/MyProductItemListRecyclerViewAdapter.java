package com.example.ocadotest.presentation.ui.products.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ocadotest.R;
import com.example.ocadotest.model.ItemModel;
import com.example.ocadotest.presentation.ui.products.fragments.ProductListFragment.OnProductListFragmentInteractionListener;

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
        holder.mItemSizeTv.setText(holder.mItem.getSize());
        //holder.mItemSizeTv.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        @BindView(R.id.item_title)
        TextView mItemTitleTv;
        @BindView(R.id.item_size)
        TextView mItemSizeTv;
        public ItemModel mItem;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
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
