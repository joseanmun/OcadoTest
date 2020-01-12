package com.example.ocadotest.presentation.ui.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ocadotest.MyApplication;
import com.example.ocadotest.injector.component.ApplicationComponent;

import butterknife.ButterKnife;


/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initializeInjector(getApplicationComponent());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }


    public void setToolbarTittle(String tittle, boolean showBack) {
        supportInvalidateOptionsMenu();
        this.getSupportActionBar().setTitle(tittle);
        showBackToolbar(showBack);
    }

    private void showBackToolbar(boolean show) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(show);
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
    protected void replaceFragment(int containerViewId, Fragment fragment, String tag, boolean backStack) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        if (backStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.replace(containerViewId, fragment, tag);
        fragmentTransaction.commit();
    }

    protected void replaceFragment(int containerViewId, Fragment fragment, String tag) {
        replaceFragment(containerViewId, fragment, tag, true);
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
