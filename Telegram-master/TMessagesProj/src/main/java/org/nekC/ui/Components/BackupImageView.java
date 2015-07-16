/*



 *
NekFriends inc. by Nekbakht Zabirov
 */

package org.nekC.ui.Components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import org.nekC.android.ImageReceiver;
import org.nekC.messenger.TLObject;
import org.nekC.messenger.TLRPC;


public class BackupImageView extends View {
    public ImageReceiver imageReceiver;
    public boolean processDetach = true;

    public BackupImageView(Context context) {
        super(context);
        init();
    }

    public BackupImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BackupImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        imageReceiver = new ImageReceiver(this);
    }

    public void setImage(TLObject path, String filter, Drawable thumb) {
        setImage(path, null, filter, thumb, null, null, null, 0);
    }

    public void setImage(TLObject path, String filter, Bitmap thumb) {
        setImage(path, null, filter, null, thumb, null, null, 0);
    }

    public void setImage(TLObject path, String filter, Drawable thumb, int size) {
        setImage(path, null, filter, thumb, null, null, null, size);
    }

    public void setImage(TLObject path, String filter, Bitmap thumb, int size) {
        setImage(path, null, filter, null, thumb, null, null, size);
    }

    public void setImage(TLObject path, String filter, TLRPC.FileLocation thumb, int size) {
        setImage(path, null, filter, null, null, thumb, null, size);
    }

    public void setImage(String path, String filter, Drawable thumb) {
        setImage(null, path, filter, thumb, null, null, null, 0);
    }

    public void setOrientation(int angle, boolean center) {
        imageReceiver.setOrientation(angle, center);
    }

    public void setImage(TLObject path, String httpUrl, String filter, Drawable thumb, Bitmap thumbBitmap, TLRPC.FileLocation thumbLocation, String thumbFilter, int size) {
        if (thumbBitmap != null) {
            thumb = new BitmapDrawable(null, thumbBitmap);
        }
        imageReceiver.setImage(path, httpUrl, filter, thumb, thumbLocation, thumbFilter, size, false);
    }

    public void setImageBitmap(Bitmap bitmap) {
        imageReceiver.setImageBitmap(bitmap);
    }

    public void setImageResource(int resId) {
        imageReceiver.setImageBitmap(getResources().getDrawable(resId));
    }

    public void setImageDrawable(Drawable drawable) {
        imageReceiver.setImageBitmap(drawable);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (processDetach) {
            imageReceiver.clearImage();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        imageReceiver.setImageCoords(0, 0, getWidth(), getHeight());
        imageReceiver.draw(canvas);
    }
}
