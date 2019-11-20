package com.example.sduasjdiajsd;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragmentTow extends Fragment {

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.tow, container, false);
        View viewById = inflate.findViewById(R.id.status_bar_view);
        init(viewById);
        return inflate;

    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    private void init(View viewById) {
        setStatusBarView(this,viewById);

    }

    private void setStatusBarView(Fragment fragmentTow, View viewById) {
        setStatusBarView(fragmentTow.getActivity(),viewById);

    }

    public static void setStatusBarView(Activity activity, View... view) {
        setStatusBarView(activity, getStatusBarHeight(activity), view);
    }

    @TargetApi(14)
    public static int getStatusBarHeight(@NonNull Activity activity) {
        BarConfig config = new BarConfig(activity);
        return config.getStatusBarHeight();
    }

    public static void setStatusBarView(Activity activity, int fixHeight, View... view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (activity == null) {
                return;
            }
            if (fixHeight < 0) {
                fixHeight = 0;
            }
            for (View v : view) {
                if (v == null) {
                    continue;
                }
                Integer fitsHeight = (Integer) v.getTag(R.id.immersion_fits_layout_overlap);
                if (fitsHeight == null) {
                    fitsHeight = 0;
                }
                if (fitsHeight != fixHeight) {
                    v.setTag(R.id.immersion_fits_layout_overlap, fixHeight);
                    ViewGroup.LayoutParams lp = v.getLayoutParams();
                    if (lp == null) {
                        lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
                    }
                    lp.height = fixHeight;
                    v.setLayoutParams(lp);
                }
            }
        }
    }

}
