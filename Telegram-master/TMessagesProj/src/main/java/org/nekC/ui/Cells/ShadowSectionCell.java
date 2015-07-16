/*
 * This is the source code of Telegram for Android v. 1.7.x.


 *

 */

package org.nekC.ui.Cells;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import org.nekC.android.AndroidUtilities;
import org.nekC.messenger.R;

public class ShadowSectionCell extends View {

    private void init() {
        setBackgroundResource(R.drawable.greydivider);
    }

    public ShadowSectionCell(Context context) {
        super(context);
        init();
    }

    public ShadowSectionCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShadowSectionCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ShadowSectionCell(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(AndroidUtilities.dp(12), MeasureSpec.EXACTLY));
    }
}
