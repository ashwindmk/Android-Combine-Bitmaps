package com.example.ashwin.joinbitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        startMerge();
    }

    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.imageView);
    }

    private void startMerge() {
        Bitmap bitmap1 = BitmapFactory.decodeResource(this.getResources(), R.drawable.image1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(this.getResources(), R.drawable.image2);
        mImageView.setImageBitmap(mergeBitmap(bitmap1, bitmap2));
    }

    private Bitmap mergeBitmap(Bitmap bitmap1, Bitmap bitmap2) {
        Bitmap mergedBitmap = null;

        int w, h = 0;

        h = bitmap1.getHeight() + 50 + bitmap2.getHeight();

        if (bitmap1.getWidth() > bitmap2.getWidth()) {
            w = bitmap1.getWidth();
        } else {
            w = bitmap2.getWidth();
        }

        mergedBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(mergedBitmap);
        canvas.drawBitmap(bitmap1, 0f, 0f, null);
        canvas.drawBitmap(bitmap2, 0f, bitmap1.getHeight() + 50f, null);

        return mergedBitmap;
    }
}
