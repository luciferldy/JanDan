package io.luciferldy.jandan.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Lucifer on 2017/3/20.
 */

public class ShrinkBehavior extends CoordinatorLayout.Behavior<FloatingActionButton> {

    float translationY;
    float percentComplete;
    float scaleFactor;

    public ShrinkBehavior() {
        super();
    }

    public ShrinkBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        return dependency instanceof Snackbar.SnackbarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton child, View dependency) {
        translationY = dependency.getHeight() - ViewCompat.getTranslationY(dependency);
        percentComplete = translationY / dependency.getHeight();
        scaleFactor = 1-percentComplete;

        child.setScaleX(scaleFactor);
        child.setScaleY(scaleFactor);
        return false;
    }
}
