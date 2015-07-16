/*
 * This is the source code of Telegram for Android v. 1.7.x.


 *

 */

package org.nekC.ui.Cells;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.nekC.android.AndroidUtilities;
import org.nekC.android.LocaleController;

public class GreySectionCell extends FrameLayout {
    private TextView textView;

    public GreySectionCell(Context context) {
        super(context);

        setBackgroundColor(0xfff2f2f2);

        textView = new TextView(getContext());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        textView.setTypeface(AndroidUtilities.getTypeface("fonts/rmedium.ttf"));
        textView.setTextColor(0xff8a8a8a);
        textView.setGravity((LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.CENTER_VERTICAL);
        addView(textView);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)textView.getLayoutParams();
        layoutParams.width = FrameLayout.LayoutParams.MATCH_PARENT;
        layoutParams.height = FrameLayout.LayoutParams.MATCH_PARENT;
        layoutParams.leftMargin = AndroidUtilities.dp(16);
        layoutParams.rightMargin = AndroidUtilities.dp(16);
        layoutParams.gravity = LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT;
        textView.setLayoutParams(layoutParams);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(36), MeasureSpec.EXACTLY));
    }

    public void setText(String text) {
        textView.setText(text);
    }
}
