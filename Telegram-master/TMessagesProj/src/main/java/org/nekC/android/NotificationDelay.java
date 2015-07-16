/*
 * This is the source code of Telegram for Android v. 2.0.x.


 *

 */

package org.nekC.android;

import android.app.IntentService;
import android.content.Intent;

public class NotificationDelay extends IntentService {

    public NotificationDelay() {
        super("NotificationDelay");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        AndroidUtilities.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                NotificationsController.getInstance().notificationDelayReached();
            }
        });
    }
}
