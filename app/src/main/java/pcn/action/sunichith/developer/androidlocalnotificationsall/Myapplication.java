package pcn.action.sunichith.developer.androidlocalnotificationsall;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;


public class Myapplication extends Application {

    public static Context context;
    MyAppsNotificationManager myAppsNotificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        myAppsNotificationManager = MyAppsNotificationManager.getInstance(this);
        myAppsNotificationManager.registerNotificationChannelChannel(
                getString(R.string.NEWS_CHANNEL_ID),
                getString(R.string.CHANNEL_NEWS),
                getString(R.string.CHANNEL_DESCRIPTION));

        myAppsNotificationManager.registerNotificationChannelChannel(
                getString(R.string.MESSAGE_CHANNEL_ID),
                getString(R.string.CHANNEL_MESSAGE),
                getString(R.string.MESSAGE_CHANNEL_DESCRIPTION));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            myAppsNotificationManager.registerNotificationChannelChannelbuble(
                    getString(R.string.Buble_CHANNEL_ID),
                    getString(R.string.CHANNEL_Buble),
                    getString(R.string.Buble_CHANNEL_DESCRIPTION));
        }


    }

    public static Context getContext(){
        return context;
    }

    public static Activity getActivity(){
        return getActivity();
    }



    public void triggerNotification(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){
        myAppsNotificationManager.triggerNotification(targetNotificationActivity,channelId,title,text, bigText, priority, autoCancel,notificationId, pendingIntentFlag);
    }

    public void triggerNotification(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId){
        myAppsNotificationManager.triggerNotification(targetNotificationActivity,channelId,title,text, bigText, priority, autoCancel,notificationId);
    }

    public void triggerNotificationWithBackStack(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){
        myAppsNotificationManager.triggerNotificationWithBackStack(targetNotificationActivity,channelId,title,text, bigText, priority, autoCancel,notificationId, pendingIntentFlag);
    }

    public void updateNotification(Class targetNotificationActivity,String user_name,String user_id,String title,String text, String channelId, int notificationId, String bigpictureString, int pendingIntentflag){
        myAppsNotificationManager.updateWithPicture(targetNotificationActivity,user_name,user_id, title, text, channelId, notificationId, bigpictureString, pendingIntentflag);
    }


    public void triggerNotificationmessaheInput(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){
        myAppsNotificationManager.triggerNotificationMessageInput(targetNotificationActivity,channelId,title,text, bigText, priority, autoCancel,notificationId, pendingIntentFlag);
    }

    public void triggerNotificationAddbutton(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){
        myAppsNotificationManager.triggerNotificationAddButton(targetNotificationActivity,channelId,title,text, bigText, priority, autoCancel,notificationId, pendingIntentFlag);
    }

    public void triggerNotificationCustomview(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){
        myAppsNotificationManager.triggerNotificationCustomviews(targetNotificationActivity,channelId,title,text, bigText, priority, autoCancel,notificationId, pendingIntentFlag);
    }

    public void triggerNotificationbuble(Class targetNotificationActivity, String channelId, String title, String text, String bigText, int priority, boolean autoCancel, int notificationId, int pendingIntentFlag){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            myAppsNotificationManager.triggerNotificationBuble(targetNotificationActivity,channelId,title,text, bigText, priority, autoCancel,notificationId);
        }
    }

    public void cancelNotification(int notificaitonId){
        myAppsNotificationManager.cancelNotification(notificaitonId);
    }


}
