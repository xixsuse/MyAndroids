package com.j.ui.miscellaneous;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.j.R;


/**
 * Created by Administrator on 2015/8/13.
 */
public class NotificationTest extends Activity {
    final int notification_id = 0x123;
    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void sendNotification(View view) {
        Intent intent = new Intent(NotificationTest.this, NotificationTest2.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(NotificationTest.this, 0, intent, 0);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("有新消息")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("因为爱情")
                .setContentText("林蕴诗，我爱你！")
                .setContentIntent(pendingIntent)
                .build();
        notificationManager.notify(notification_id, notification);
    }

    public void cancelNotification(View view) {
        notificationManager.cancel(notification_id);
    }
}
