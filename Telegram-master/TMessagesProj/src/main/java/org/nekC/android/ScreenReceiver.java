/*
NekFriends inc. by Nekbakht Zabirov


 *

 */

package org.nekC.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.nekC.messenger.ConnectionsManager;
import org.nekC.messenger.FileLog;
import org.nekC.messenger.ApplicationLoader;

public class ScreenReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            FileLog.e("tmessages", "screen off");
            ConnectionsManager.getInstance().setAppPaused(true, true);
            ApplicationLoader.isScreenOn = false;
        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            FileLog.e("tmessages", "screen on");
            ConnectionsManager.getInstance().setAppPaused(false, true);
            ApplicationLoader.isScreenOn = true;
        }
        NotificationCenter.getInstance().postNotificationName(NotificationCenter.screenStateChanged);
    }
}
