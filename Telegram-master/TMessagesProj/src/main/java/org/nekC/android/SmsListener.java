/*



 *
NekFriends inc. by Nekbakht Zabirov
 */

package org.nekC.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsMessage;

import org.nekC.messenger.FileLog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsListener extends BroadcastReceiver {

    private SharedPreferences preferences;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            if (!AndroidUtilities.isWaitingForSms()) {
                return;
            }
            Bundle bundle = intent.getExtras();
            SmsMessage[] msgs;
            if (bundle != null) {
                try {
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    String wholeString = "";
                    for(int i = 0; i < msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        wholeString += msgs[i].getMessageBody();
                    }

                    try {
                        Pattern pattern = Pattern.compile("[0-9]+");
                        Matcher matcher = pattern.matcher(wholeString);
                        if (matcher.find()) {
                            String str = matcher.group(0);
                            if (str.length() >= 3) {
                                NotificationCenter.getInstance().postNotificationName(NotificationCenter.didReceiveSmsCode, matcher.group(0));
                            }
                        }
                    } catch (Exception e) {
                        FileLog.e("tmessages", e);
                    }

                } catch(Exception e) {
                    FileLog.e("tmessages", e);
                }
            }
        }
    }
}
