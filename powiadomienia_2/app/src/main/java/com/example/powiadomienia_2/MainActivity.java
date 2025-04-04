package com.example.powiadomienia_2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String Channel_ID="ID";
    private Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.button2);
        btn3=findViewById(R.id.button3);


        createNotificationChannel();
        btn1.setOnClickListener(view -> BigTextStyle() );
        btn2.setOnClickListener(view -> BigTextStyle() );
        btn3.setOnClickListener(view ->InboxStyle());
    }
    private void createNotificationChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

            CharSequence name = "kanal_powaidomien";
            String opsi_kanalu = "opis_kanalu_powiadomien";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel  channel = new NotificationChannel(Channel_ID,name,importance);
            channel.setDescription(opsi_kanalu);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
    private  void  BigTextStyle(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Channel_ID).setContentTitle("BigTextStyle").setStyle(new NotificationCompat.BigTextStyle().bigText("cewrewrwerwerwevsmvdflkvndfvndfvnjdfnbjdbnldbnlfgbnlfgbnlfgnblfbfnbdfbgdfnbdfngbjbdfgnbjldfbnjdfbn")).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            NotificationManagerCompat notificationM= NotificationManagerCompat.from(this);
            notificationM.notify(1,builder.build());

        }
    }

    private  void  BigPictureStyle(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.dice1);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Channel_ID).setSmallIcon(R.drawable.dice1).setContentTitle("BigPictureStyle").setStyle(new NotificationCompat.BigPictureStyle().bigLargeIcon(bitmap)).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            NotificationManagerCompat notificationM= NotificationManagerCompat.from(this);
            notificationM.notify(1,builder.build());

        }
    }

    private  void InboxStyle(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, 1);
                return;
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Channel_ID).setSmallIcon(R.drawable.dice1).setContentTitle("InboxStyle").setStyle(new NotificationCompat.InboxStyle().addLine("linia 1").addLine("Linia 2").addLine("Linia 3")).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            NotificationManagerCompat notificationM= NotificationManagerCompat.from(this);
            notificationM.notify(1,builder.build());

        }
    }
}