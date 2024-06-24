package pcn.action.sunichith.developer.androidlocalnotificationsall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OncLickReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("ONRECEIVE","onclick");
    }
}
