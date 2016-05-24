package com.j.fragment.simple;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.j.R;

/**
 * Created by Administrator on 2015/9/10.
 */
public class SimpleFragmentRight extends Fragment {
    String TAG = getClass().getSimpleName();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
        return inflater.inflate(R.layout.simple_fragment_right, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
