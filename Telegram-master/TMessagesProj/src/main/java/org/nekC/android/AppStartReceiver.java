/*
NekFriends inc. by Nekbakht Zabirov


 *

 */

package org.nekC.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.nekC.messenger.ApplicationLoader;

public class AppStartReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        AndroidUtilities.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                ApplicationLoader.startPushService();
            }
        });
    }
}
