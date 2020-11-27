package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //创建一个Notification对象
                Notification.Builder notification = new Notification.Builder(MainActivity.this);
                //设置打开通知，消息消失
                notification.setAutoCancel(true);
                notification.setSmallIcon(R.mipmap.ic_launcher_round);
                notification.setContentTitle("状态信息");
                notification.setContentText("点我看看");
                notification.setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE);
                notification.setWhen(System.currentTimeMillis());

                //创建启动Activity的Intent对象
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                notification.setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0x11,notification.build());
            }
        });
    }
}
