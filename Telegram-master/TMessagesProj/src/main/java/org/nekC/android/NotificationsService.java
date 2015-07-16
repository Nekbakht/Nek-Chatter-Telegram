/*
NekFriends inc. by Nekbakht Zabirov


 *

 */

package org.nekC.android;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

import org.nekC.messenger.FileLog;
import org.nekC.messenger.ApplicationLoader;

public class NotificationsService extends Service {

    @Override
    public void onCreate() {
        FileLog.e("tmessages", "service started");
        ApplicationLoader.postInitApplication();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy() {
        FileLog.e("tmessages", "service destroyed");

        SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("Notifications", MODE_PRIVATE);
        if (preferences.getBoolean("pushService", true)) {
            Intent intent = new Intent("org.nekC.start");
            sendBroadcast(intent);
        }
    }
}
