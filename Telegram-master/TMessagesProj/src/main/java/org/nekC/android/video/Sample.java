/*
 * This is the source code of Telegram for Android v. 1.7.x.


 *

 */

package org.nekC.android.video;

public class Sample {
    private long offset = 0;
    private long size = 0;

    public Sample(long offset, long size) {
        this.offset = offset;
        this.size = size;
    }

    public long getOffset() {
        return offset;
    }

    public long getSize() {
        return size;
    }
}
