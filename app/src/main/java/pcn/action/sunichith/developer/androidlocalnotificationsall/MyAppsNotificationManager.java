package pcn.action.sunichith.developer.androidlocalnotificationsall;

import static androidx.core.app.RemoteInput.EDIT_CHOICES_BEFORE_SENDING_DISABLED;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.RemoteInput;
import androidx.core.graphics.drawable.IconCompat;


public class MyAppsNotificationManager {

    private Context context;

    private static MyAppsNotificationManager instance;
    private NotificationManagerCompat notificationManagerCompat;
    private NotificationManager notificationManager;

    private MyAppsNotificationManager(Context context){
        this.context = context;
        notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static MyAppsNotificationManager getInstance(Context context){
        if(instance==null){
            instance = new MyAppsNotificationManager(context);
        }
        return instance;
    }

    public void registerNotificationChannelChannel(String channelId, String channelName, String channelDescription) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(channelDescription);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void registerNotificationChannelChannelbuble(String channelId, String channelName, String channelDescription) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
            notificationChannel.setDescription(channelDescription);
            notificationChannel.setAllowBubbles(true);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    public void triggerNotification(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId){

        Intent intent = new Intent(context, targetNotificationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_MUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2))
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(notificationId,builder.build());
    }

    public void triggerNotification(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){

        Intent intent = new Intent(context, targetNotificationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, pendingIntentFlag);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2))
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .setAutoCancel(true);

        notificationManagerCompat.notify(notificationId,builder.build());
    }

    public void triggerNotificationWithBackStack(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){

        Intent intent = new Intent(context, targetNotificationActivity);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(context);
        taskStackBuilder.addNextIntentWithParentStack(intent);
        intent.putExtra("count", title);
        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, pendingIntentFlag);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2))
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .setAutoCancel(true);

        notificationManagerCompat.notify(notificationId,builder.build());
    }

    public void updateWithPicture(Class targetNotificationActivity,String user_name,String user_id,String title,String text, String channelId, int notificationId, String bigpictureString, int pendingIntentflag) {

        Intent intent = new Intent(context, targetNotificationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, pendingIntentflag);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.avatar_1))
                .setContentTitle(title)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .setAutoCancel(true);

        Bitmap androidImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(androidImage).setBigContentTitle(bigpictureString));
        notificationManager.notify(notificationId, builder.build());
    }


    public void triggerNotificationMessageInput(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){

        Intent intent = new Intent(context, targetNotificationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, pendingIntentFlag);


        // inline a=edittext
        // Key for the string that's delivered in the action's intent.
        final String KEY_TEXT_REPLY = "key_text_reply";
        String replyLabel = "send messsage";
        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
                .setLabel(replyLabel)
                .setAllowFreeFormInput(true)
                .setEditChoicesBeforeSending(
                        EDIT_CHOICES_BEFORE_SENDING_DISABLED )
                .build();
        // Create the reply action and add the remote input.
        Intent activityIntent=new Intent(context, MessageReceiver.class);
        activityIntent.putExtra("name","dinesh");
        activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent replypending=PendingIntent.getBroadcast(context,9,activityIntent,PendingIntent.FLAG_MUTABLE|PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.dharma2,
                        "Reply", replypending)
                        .addRemoteInput(remoteInput)
                        .build();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2))
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .addAction(action)
                .setAutoCancel(true);

        notificationManagerCompat.notify(notificationId,builder.build());
    }


    public void triggerNotificationAddButton(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){

        Intent intent = new Intent(context, targetNotificationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, pendingIntentFlag);

        Intent activityIntent=new Intent(context, MainActivity.class);
        activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent playpendingIntent1=PendingIntent.getActivity(context,2,activityIntent,PendingIntent.FLAG_MUTABLE);

        PendingIntent cancelpendingIntent1=PendingIntent.getActivity(context,2,activityIntent,PendingIntent.FLAG_MUTABLE);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2))
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .addAction(R.drawable.dharma2,"PLAY",playpendingIntent1)
                .addAction(R.drawable.dharma2,"CANCEL",cancelpendingIntent1)
                .setAutoCancel(true);

        notificationManagerCompat.notify(notificationId,builder.build());
    }


    public void triggerNotificationCustomviews(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){

        Intent intent = new Intent(context, targetNotificationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, pendingIntentFlag);


        Intent closeButton = new Intent(context,OncLickReceiver.class);
        closeButton.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingSwitchIntent = PendingIntent.getBroadcast(context, 6, closeButton, PendingIntent.FLAG_MUTABLE);


        RemoteViews remotecollapsview=new RemoteViews(context.getPackageName(),R.layout.customlayout_noti);
        remotecollapsview.setOnClickPendingIntent(R.id.button, pendingSwitchIntent);
        RemoteViews remoteViewsexpanded=new RemoteViews(context.getPackageName(),R.layout.customlayout_expand);
        remoteViewsexpanded.setTextViewText(R.id.text_exp,title);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2))
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .setAutoCancel(true)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setCustomContentView(remotecollapsview)
                .setCustomBigContentView(remoteViewsexpanded);

        notificationManagerCompat.notify(notificationId,builder.build());
    }


    @RequiresApi(api = Build.VERSION_CODES.Q)
    public void triggerNotificationBuble(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId){

        Intent intent = new Intent(context, targetNotificationActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_MUTABLE);

        @SuppressLint("RestrictedApi") NotificationCompat.BubbleMetadata bubbleData =
                new NotificationCompat.BubbleMetadata.Builder()
                        .setDesiredHeight(600)
                        .setAutoExpandBubble(true)
                        .setIcon(IconCompat.createFromIcon(Icon.createWithResource(context, R.drawable.avatar_1)))
                            .setIntent(pendingIntent)
                .build();


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,channelId)
                .setSmallIcon(R.drawable.dharma2)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.dharma2))
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setChannelId(channelId)
                .setAutoCancel(true)
                .setBubbleMetadata(bubbleData);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(notificationId,builder.build());
    }


    public void cancelNotification(int notificationId){
        notificationManager.cancel(notificationId);
    }
}
