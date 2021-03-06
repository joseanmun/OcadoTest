/*
 * Created by Anselmo Jose Munoz Medina on 1/13/20 1:03 PM
 * Email: Joseanmun@gmail.com
 *
 * Copyright (c) 2020 . All rights reserved.
 * Last modified 1/12/20 9:19 PM
 */

package com.example.ocadotest.presentation.ui.products.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ocadotest.R;
import com.example.ocadotest.injector.component.DaggerProductsComponent;
import com.example.ocadotest.injector.module.ActivityModule;
import com.example.ocadotest.injector.module.ProductsModule;
import com.example.ocadotest.model.ProductModel;
import com.example.ocadotest.presentation.presenter.products.ProductListPresenter;
import com.example.ocadotest.presentation.ui.base.BaseActivity;
import com.example.ocadotest.presentation.ui.base.BaseFragment;
import com.example.ocadotest.presentation.ui.products.adapters.MyProductListRecyclerViewAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnProductListFragmentInteractionListener}
 * interface.
 */
public class ProductListFragment extends BaseFragment implements ProductListPresenter.View {
    private OnProductListFragmentInteractionListener mListener;

    @BindView(R.id.products_rv)
    RecyclerView recyclerView;
    @BindView(R.id.common_progress_bar)
    View progressBarView;

    @Inject
    ProductListPresenter productListPresenter;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductListFragment() {
    }

    @SuppressWarnings("unused")
    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
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
        productListPresenter.setView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((BaseActivity) getActivity()).setToolbarTittle(getString(R.string.fragment_product_title), false);
        productListPresenter.getProducts();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_productlist_list, container, false);
        ButterKnife.bind(this, view);

        Context context = view.getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProductListFragmentInteractionListener) {
            mListener = (OnProductListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnProductListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setItems(List<ProductModel> productModels) {
        recyclerView.setAdapter(new MyProductListRecyclerViewAdapter(productModels, mListener));
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
                        productListPresenter.getProducts();
                    }
                });
        snackbar.show();
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnProductListFragmentInteractionListener {
        void onProductItemSelected(int itemId);
    }
}
