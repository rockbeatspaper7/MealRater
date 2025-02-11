package com.example.mealrater;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements MealRaterActivity.OnRatingListener {

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
        initRateButton();
    }

    private void initRateButton() {
        Button rate = findViewById(R.id.buttonRate);
        rate.setOnClickListener(v -> {
            MealRaterActivity dialog = new MealRaterActivity();
            dialog.show(getSupportFragmentManager(), "Rating");
        });
    }

    @Override
    public void onRating(int rating) {
        TextView ratingView = findViewById(R.id.ratingText);
        ratingView.setText(rating);
    }
}
