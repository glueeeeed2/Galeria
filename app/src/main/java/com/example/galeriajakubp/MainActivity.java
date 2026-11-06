package com.example.galeriajakubp;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button nextBtn;
    private Button backBtn;

    private ImageView imageView;

    private int image = 0;

    private List<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loadImages();
        changeImage(image);

        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);
        imageView = findViewById(R.id.imageView2);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage(image + 1);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (image == 0) {
                    image = images.size() - 1;
                } else {
                    image--;
                }
            }
        });


    }

    private void changeImage(int index) {
        imageView.setImageResource((int) images.get(index));
    }


    private void loadImages() {
        images.add(R.drawable.szynszyla1);
        images.add(R.drawable.szynszyla2);
        images.add(R.drawable.szynszyla3);
        images.add(R.drawable.szynszyla4);
    }
}