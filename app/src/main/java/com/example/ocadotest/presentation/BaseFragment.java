
package com.example.ocadotest.presentation;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Base {@link Fragment} class for every fragment in this application.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initializePresenter();
    }

    abstract void initializePresenter();
}
