/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.presentation.ui.products.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ocadotest.R;
import com.example.ocadotest.injector.component.DaggerProductsComponent;
import com.example.ocadotest.injector.module.ActivityModule;
import com.example.ocadotest.injector.module.ProductsModule;
import com.example.ocadotest.model.ItemDetailModel;
import com.example.ocadotest.presentation.presenter.products.ItemDetailPresenter;
import com.example.ocadotest.presentation.ui.base.BaseActivity;
import com.example.ocadotest.presentation.ui.base.BaseFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ItemDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetailFragment extends BaseFragment implements ItemDetailPresenter.View {
    private static final String ARG_PARAM_ITEM_ID = ItemDetailFragment.class.toString() + "ARG_PARAM_ITEM_ID";
    private static final Integer INVALID_ITEM_ID = -1;
    private int mItemId;

    @Inject
    ItemDetailPresenter itemDetailPresenter;

    @BindView(R.id.common_progress_bar)
    View progressBarView;

    @BindView(R.id.description_tv)
    TextView descriptionTv;
    @BindView(R.id.item_title)
    TextView mItemTitleTv;
    @BindView(R.id.item_allergies)
    TextView mItemAllergiestv;
    @BindView(R.id.item_price)
    TextView mItemPrice;
    @BindView((R.id.product_iv))
    ImageView mItemIv;

    public ItemDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param itemId Parameter 1.
     * @return A new instance of fragment ItemDetailFragment.
     */
    public static ItemDetailFragment newInstance(int itemId) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_ITEM_ID, itemId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void initializePresenter() {
        BaseActivity activity = (BaseActivity) getActivity();

        DaggerProductsComponent.builder()
                .applicationComponent(activity.getApplicationComponent())
                .activityModule(new ActivityModule(activity))
                .productsModule(new ProductsModule())
                .build()
                .inject(this);
        itemDetailPresenter.setView(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mItemId = getArguments().getInt(ARG_PARAM_ITEM_ID, INVALID_ITEM_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BaseActivity) getActivity()).setToolbarTittle(getString(R.string.fragment_item_detail_title), true);
        itemDetailPresenter.getItemDetail(mItemId);
    }

    @Override
    public void renderItemDetail(ItemDetailModel itemDetailModel) {
        Picasso.with(getActivity()).load(itemDetailModel.getImageUrl()).error(R.drawable.ic_error_brown_50_24dp)
                .fit().centerCrop().into(mItemIv);
        mItemTitleTv.setText(itemDetailModel.getTitle());
        descriptionTv.setText(itemDetailModel.getDescription());
        mItemAllergiestv.setText(itemDetailModel.getAllergyInformation());
        mItemPrice.setText(getString(R.string.price_format, itemDetailModel.getPrice()));
    }

    @Override
    public void showProgress() {
        progressBarView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBarView.setVisibility(View.GONE);
    }


    @Override
    public void showMessage(String message) {
        Snackbar snackbar = Snackbar
                .make(getActivity().findViewById(R.id.container), getString(R.string.common_error_message), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.common_error_retry), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemDetailPresenter.getItemDetail(mItemId);
                    }
                });
        snackbar.show();
    }
}
