package com.example.ocadotest.presentation;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.ocadotest.MyApplication;
import com.example.ocadotest.R;
import com.example.ocadotest.injector.component.ApplicationComponent;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Nullable
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initializeInjector(getApplicationComponent());
    }

    protected void setUpToolbar(boolean showUpButton) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (getSupportActionBar() != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(showUpButton);
            }
        }
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where replace the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    /**
     * Replaces a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where replace the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void replaceFragment(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }

    /**
     * Get the Main Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    public ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getComponent();
    }

    /**
     * Initialize injections by field.
     *
     * @param applicationComponent {@link ApplicationComponent} main component.
     */
    protected abstract void initializeInjector(ApplicationComponent applicationComponent);
}
