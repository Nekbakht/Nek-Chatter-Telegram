/*



 *
NekFriends inc. by Nekbakht Zabirov
 */

package org.nekC.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.json.JSONObject;
import org.nekC.messenger.ConnectionsManager;
import org.nekC.messenger.FileLog;
import org.nekC.messenger.ApplicationLoader;

public class GcmBroadcastReceiver extends BroadcastReceiver {

    public static final int NOTIFICATION_ID = 1;

    @Override
    public void onReceive(final Context context, final Intent intent) {
        FileLog.d("tmessages", "GCM received intent: " + intent);

        if (intent.getAction().equals("com.google.android.c2dm.intent.RECEIVE")) {
            AndroidUtilities.runOnUIThread(new Runnable() {
                @Override
                public void run() {
                    ApplicationLoader.postInitApplication();

                    try {
                        String key = intent.getStringExtra("loc_key");
                        if ("DC_UPDATE".equals(key)) {
                            String data = intent.getStringExtra("custom");
                            JSONObject object = new JSONObject(data);
                            int dc = object.getInt("dc");
                            String addr = object.getString("addr");
                            String[] parts = addr.split(":");
                            if (parts.length != 2) {
                                return;
                            }
                            String ip = parts[0];
                            int port = Integer.parseInt(parts[1]);
                            ConnectionsManager.getInstance().applyDcPushUpdate(dc, ip, port);
                        }
                    } catch (Exception e) {
                        FileLog.e("tmessages", e);
                    }

                    ConnectionsManager.getInstance().resumeNetworkMaybe();
                }
            });
        } else if (intent.getAction().equals("com.google.android.c2dm.intent.REGISTRATION")) {
            String registration = intent.getStringExtra("registration_id");
            if (intent.getStringExtra("error") != null) {
                FileLog.e("tmessages", "Registration failed, should try again later.");
            } else if (intent.getStringExtra("unregistered") != null) {
                FileLog.e("tmessages", "unregistration done, new messages from the authorized sender will be rejected");
            } else if (registration != null) {
                FileLog.e("tmessages", "registration id = " + registration);
            }
        }

        setResultCode(Activity.RESULT_OK);
    }
}