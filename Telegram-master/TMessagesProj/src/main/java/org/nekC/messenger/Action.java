/*



 *
NekFriends inc. by Nekbakht Zabirov
 */

package org.nekC.messenger;

import java.util.HashMap;

public class Action {
    public interface ActionDelegate {
        void ActionDidFinishExecution(Action action, HashMap<String, Object> params);
        void ActionDidFailExecution(Action action);
    }

    public ActionDelegate delegate;

    public void execute(HashMap params) {

    }

    public void cancel() {

    }
}
