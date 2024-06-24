package pcn.action.sunichith.developer.androidlocalnotificationsall;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

public class MessageReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String KEY_TEXT_REPLY = "key_text_reply";
        Bundle results = RemoteInput.getResultsFromIntent(intent);
        if (results != null) {
            CharSequence quickReplyResult = results.getCharSequence(KEY_TEXT_REPLY);
            Log.e("data", (String) quickReplyResult);

            Log.e("name",intent.getStringExtra("name"));
            MyAppsNotificationManager.getInstance(context).cancelNotification(1001);
           // Toast.makeText(this, quickReplyResult, Toast.LENGTH_SHORT).show();
        }

       /* ((Myapplication)context.getApplicationContext()).triggerNotificationmessaheInput(MainActivity.class,
                context.getString(R.string.MESSAGE_CHANNEL_ID),
                "Popular quotes",
                "Be yourself; everyone else is already taken",
                "“You've gotta dance like there's nobody watching,\n" +
                        "Love like you'll never be hurt,\n" +
                        "Sing like there's nobody listening,\n" +
                        "And live like it's heaven on earth.”",
                NotificationCompat.PRIORITY_HIGH,
                false,
                Integer.parseInt("1001"),
                PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);*/

  }
}