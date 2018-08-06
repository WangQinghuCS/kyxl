package com.example.chronicdisease;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CheckableLinearLayout extends android.support.v7.widget.AppCompatTextView implements Checkable {
    private boolean mChecked;
    public CheckableLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void setChecked(boolean checked) {
        mChecked = checked;
        setBackgroundDrawable(checked ? new ColorDrawable(R.drawable.selector_listview) : null);//当选中时呈现蓝色
    }
    @Override
    public boolean isChecked() {
        return mChecked;
    }
    @Override
    public void toggle() {
        setChecked(!mChecked);
    }
}
