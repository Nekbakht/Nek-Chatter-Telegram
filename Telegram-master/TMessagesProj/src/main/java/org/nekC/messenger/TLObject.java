/*



 *
NekFriends inc. by Nekbakht Zabirov
 */

package org.nekC.messenger;

public class TLObject {
    public boolean disableFree = false;

    public TLObject () {

    }

    public void readParams(AbsSerializedData stream) {

    }

    public byte[] serialize () {
        return null;
    }

    public void serializeToStream(AbsSerializedData stream) {

    }

    public Class<? extends TLObject> responseClass () {
        return this.getClass();
    }

    public int layer () {
       return 11;
    }

    public void parseVector(TLRPC.Vector vector, AbsSerializedData data) {

    }

    public void freeResources() {

    }

    public int getObjectSize() {
        ByteBufferDesc bufferDesc = new ByteBufferDesc(true);
        serializeToStream(bufferDesc);
        return bufferDesc.length();
    }
}
