/*
 * This is the source code of Telegram for Android v. 2.x


 *
 * Copyright Nikolai Kudashov, 2013-2015.
 */

package org.nekC.ui.Components;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;

import org.nekC.messenger.FileLog;

import java.util.concurrent.CopyOnWriteArrayList;

public class ForegroundDetector implements Application.ActivityLifecycleCallbacks {

    public interface Listener {
        public void onBecameForeground();
        public void onBecameBackground();
    }

    private int refs;
    private boolean wasInBackground = true;
    private long enterBackgroundTime = 0;
    private CopyOnWriteArrayList<Listener> listeners = new CopyOnWriteArrayList<>();
    private static ForegroundDetector Instance = null;

    public static ForegroundDetector getInstance() {
        return Instance;
    }

    public ForegroundDetector(Application application) {
        Instance = this;
        application.registerActivityLifecycleCallbacks(this);
    }

    public boolean isForeground() {
        return refs > 0;
    }

    public boolean isBackground() {
        return refs == 0;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (++refs == 1) {
            if (System.currentTimeMillis() - enterBackgroundTime < 200) {
                wasInBackground = false;
            }
            FileLog.e("tmessages", "switch to foreground");
            for (Listener listener : listeners) {
                try {
                    listener.onBecameForeground();
                } catch (Exception e) {
                    FileLog.e("tmessages", e);
                }
            }
        }
    }

    public boolean isWasInBackground(boolean reset) {
        if (reset && Build.VERSION.SDK_INT >= 21 && (System.currentTimeMillis() - enterBackgroundTime < 200)) {
            wasInBackground = false;
        }
        return wasInBackground;
    }

    public void resetBackgroundVar() {
        wasInBackground = false;
    }

    @Override
    public void onActivityStopped(Activity activity) {
        if (--refs == 0) {
            enterBackgroundTime = System.currentTimeMillis();
            wasInBackground = true;
            FileLog.e("tmessages", "switch to background");
            for (Listener listener : listeners) {
                try {
                    listener.onBecameBackground();
                } catch (Exception e) {
                    FileLog.e("tmessages", e);
                }
            }
        }
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
    }
}
