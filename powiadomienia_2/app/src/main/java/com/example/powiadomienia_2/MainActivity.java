package com.example.powiadomienia_2;

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

        btn1.setOnClickListener(view -> BigTextStyle() );
        btn2.setOnClickListener(view -> BigTextStyle() );
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
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.)
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this,Channel_ID).setContentTitle("BigTextStyle").setStyle(new NotificationCompat.BigTextStyle().bigText("cewrewrwerwerwevsmvdflkvndfvndfvnjdfnbjdbnldbnlfgbnlfgbnlfgnblfbfnbdfbgdfnbdfngbjbdfgnbjldfbnjdfbn")).setPriority(NotificationCompat.PRIORITY_DEFAULT).setAutoCancel(true);
            NotificationManagerCompat notificationM= NotificationManagerCompat.from(this);
            notificationM.notify(1,builder.build());

        }
    }
}