/*
 * This is the source code of Telegram for Android v. 2.0.x.


 *

 */

package org.nekC.ui.Cells;

import android.content.Context;
import android.view.Gravity;
import android.widget.FrameLayout;

import org.nekC.android.AndroidUtilities;
import org.nekC.messenger.R;
import org.nekC.ui.Components.BackupImageView;
import org.nekC.ui.Components.CheckBox;

public class PhotoPickerPhotoCell extends FrameLayout {

    public BackupImageView photoImage;
    public FrameLayout checkFrame;
    public CheckBox checkBox;
    public int itemWidth;

    public PhotoPickerPhotoCell(Context context) {
        super(context);

        photoImage = new BackupImageView(context);
        addView(photoImage);
        LayoutParams layoutParams = (LayoutParams) photoImage.getLayoutParams();
        layoutParams.width = LayoutParams.MATCH_PARENT;
        layoutParams.height = LayoutParams.MATCH_PARENT;
        photoImage.setLayoutParams(layoutParams);

        checkFrame = new FrameLayout(context);
        addView(checkFrame);
        layoutParams = (LayoutParams) checkFrame.getLayoutParams();
        layoutParams.width = AndroidUtilities.dp(42);
        layoutParams.height = AndroidUtilities.dp(42);
        layoutParams.gravity = Gravity.RIGHT | Gravity.TOP;
        checkFrame.setLayoutParams(layoutParams);

        checkBox = new CheckBox(context, R.drawable.checkbig);
        checkBox.setSize(30);
        checkBox.setCheckOffset(AndroidUtilities.dp(1));
        checkBox.setDrawBackground(true);
        checkBox.setColor(0xff3ccaef);
        addView(checkBox);
        layoutParams = (LayoutParams) checkBox.getLayoutParams();
        layoutParams.width = AndroidUtilities.dp(30);
        layoutParams.height = AndroidUtilities.dp(30);
        layoutParams.gravity = Gravity.RIGHT | Gravity.TOP;
        layoutParams.topMargin = AndroidUtilities.dp(6);
        layoutParams.rightMargin = AndroidUtilities.dp(6);
        checkBox.setLayoutParams(layoutParams);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(itemWidth, MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(itemWidth, MeasureSpec.EXACTLY));
    }
}
