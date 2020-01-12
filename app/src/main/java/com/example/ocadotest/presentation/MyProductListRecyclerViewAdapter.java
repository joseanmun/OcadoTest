package com.example.ocadotest.presentation;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ocadotest.R;
import com.example.ocadotest.model.ItemModel;
import com.example.ocadotest.model.ProductModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link ProductModel} and makes a call to the
 * specified {@link ProductListFragment.OnProductListFragmentInteractionListener}.
 */
public class MyProductListRecyclerViewAdapter extends RecyclerView.Adapter<MyProductListRecyclerViewAdapter.ViewHolder> {

    private final List<ProductModel> mProductList;
    private ProductListFragment.OnProductListFragmentInteractionListener mlistener;

    public MyProductListRecyclerViewAdapter(List<ProductModel> items, ProductListFragment.OnProductListFragmentInteractionListener listener) {
        mProductList = items;
        mlistener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_productlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mProductList.get(position);
        holder.mProductTagTv.setText(holder.mItem.getTag());
        holder.setUpItemsRecyclerView(holder.mItem.getItems());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;

        View mView;
        @BindView(R.id.item_list_rv)
        RecyclerView itemsRecyclerView;
        @BindView(R.id.product_tag_tv)
        TextView mProductTagTv;
        public ProductModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);
            context = view.getContext();
        }

        public void setUpItemsRecyclerView(List<ItemModel> itemModels) {
            final LinearLayoutManager layoutManager =
                    new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
            MyProductItemListRecyclerViewAdapter adapter =
                    new MyProductItemListRecyclerViewAdapter(itemModels, mlistener);
            itemsRecyclerView.setAdapter(adapter);
            //devAppsRecyclerView.addItemDecoration(new HorizontalItemDecorator((int) mContext.getResources().getDimension(R.dimen.padding_size_small)));
            itemsRecyclerView.setLayoutManager(layoutManager);
            itemsRecyclerView.setHasFixedSize(true);
        }


    }
}
