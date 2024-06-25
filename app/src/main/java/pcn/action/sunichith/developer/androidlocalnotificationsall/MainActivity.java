package pcn.action.sunichith.developer.androidlocalnotificationsall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    Button btn_send,btn_update,RemoteInput_btn,addaction_btn,customview_btn,createbuble;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU)
        {
            if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.POST_NOTIFICATIONS)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{android.Manifest.permission.POST_NOTIFICATIONS},101);
            }
        }

        btn_send=findViewById(R.id.send_btn);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Myapplication)getApplication()).triggerNotificationWithBackStack(MainActivity.class,
                        getString(R.string.MESSAGE_CHANNEL_ID),
                        "Popular quotes",
                       "Be yourself; everyone else is already taken",
                        "“You've gotta dance like there's nobody watching,\n" +
                                "Love like you'll never be hurt,\n" +
                                "Sing like there's nobody listening,\n" +
                                "And live like it's heaven on earth.”",
                        NotificationCompat.PRIORITY_HIGH,
                        false,
                        Integer.parseInt("1001"),
                        PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
            }
        });

        btn_update=findViewById(R.id.update_btn);
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Myapplication)getApplication()).updateNotification(MainActivity.class,"Popular quotes", "Be yourself; everyone else is already taken",
                        "Popular quotes",
                        "Be yourself; everyone else is already taken",
                        getString(R.string.NEWS_CHANNEL_ID),
                        getResources().getInteger(R.integer.notificationId),
                        "“You've gotta dance like there's nobody watching,\n" +
                                "Love like you'll never be hurt,\n" +
                                "Sing like there's nobody listening,\n" +
                                "And live like it's heaven on earth.”",
                        PendingIntent.FLAG_UPDATE_CURRENT|PendingIntent.FLAG_IMMUTABLE);
            }
        });

        RemoteInput_btn=findViewById(R.id.RemoteInput_btn);
        RemoteInput_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Myapplication)getApplication()).triggerNotificationmessaheInput(MainActivity.class,
                        getString(R.string.MESSAGE_CHANNEL_ID),
                        "Popular quotes",
                        "Be yourself; everyone else is already taken",
                        "“You've gotta dance like there's nobody watching,\n" +
                                "Love like you'll never be hurt,\n" +
                                "Sing like there's nobody listening,\n" +
                                "And live like it's heaven on earth.”",
                        NotificationCompat.PRIORITY_DEFAULT,
                        true,
                        Integer.parseInt("1001"),
                        PendingIntent.FLAG_MUTABLE);
            }
        });

        addaction_btn=findViewById(R.id.addaction_btn);
        addaction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Myapplication)getApplication()).triggerNotificationAddbutton(MainActivity.class,
                        getString(R.string.MESSAGE_CHANNEL_ID),
                        "Popular quotes",
                        "Be yourself; everyone else is already taken",
                        "“You've gotta dance like there's nobody watching,\n" +
                                "Love like you'll never be hurt,\n" +
                                "Sing like there's nobody listening,\n" +
                                "And live like it's heaven on earth.”",
                        NotificationCompat.PRIORITY_DEFAULT,
                        true,
                        Integer.parseInt("1001"),
                        PendingIntent.FLAG_MUTABLE);
            }
        });

        customview_btn=findViewById(R.id.customview_btn);
        customview_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Myapplication)getApplication()).triggerNotificationCustomview(MainActivity.class,
                        getString(R.string.MESSAGE_CHANNEL_ID),
                        "Popular quotes",
                        "Be yourself; everyone else is already taken",
                        "“You've gotta dance like there's nobody watching,\n" +
                                "Love like you'll never be hurt,\n" +
                                "Sing like there's nobody listening,\n" +
                                "And live like it's heaven on earth.”",
                        NotificationCompat.PRIORITY_DEFAULT,
                        true,
                        Integer.parseInt("1001"),
                        PendingIntent.FLAG_MUTABLE);
            }
        });


        createbuble=findViewById(R.id.createBubble);
        createbuble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             startActivity(new Intent(MainActivity.this, com.example.android.people.MainActivity.class));
            }
        });

    }


}