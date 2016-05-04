package com.example.pbuskell.postmethodthreadingeg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class PostMethodThreadingEg extends AppCompatActivity {

    ImageView imgvwMain;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_method_threading_eg);
    }

    public void onClick(View v)
    {
        new Thread(new Runnable()
        {
            public void run()
            {
                imgvwMain.post(new Runnable() {
                    public void run() {

                        Bitmap bitmap = null;

                        try
                        {
                            InputStream iStream = (InputStream) new URL("http://edmullen.net/test/rc.jpg").getContent();
                            bitmap = BitmapFactory.decodeStream(iStream);
                        }
                        catch(IOException ioe)
                        {
                            bitmap.createBitmap(480, 720, Bitmap.Config.ARGB_8888);
                        }

                        imgvwMain.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }


}
