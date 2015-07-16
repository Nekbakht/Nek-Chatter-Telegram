/*
 * This is the source code of Telegram for Android v. 1.7.x.


 *

 */

package org.nekC.android;

import android.app.IntentService;
import android.content.Intent;

public class NotificationRepeat extends IntentService {

    public NotificationRepeat() {
        super("NotificationRepeat");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        AndroidUtilities.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                NotificationsController.getInstance().repeatNotificationMaybe();
            }
        });
    }
}
