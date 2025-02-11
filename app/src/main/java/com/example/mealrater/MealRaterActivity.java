package com.example.mealrater;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;


public class MealRaterActivity extends DialogFragment {

    private RatingBar ratingBar;

    public interface OnRatingListener {
        void onRating(int rating);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meal_rater, container, false);

        ratingBar = view.findViewById(R.id.ratingBar);

        Button rateButton = view.findViewById(R.id.saveButton);
        rateButton.setOnClickListener(v -> {
            int rating = (int) ratingBar.getRating();
            OnRatingListener activity = (OnRatingListener) getActivity();
            if (activity != null) {
                activity.onRating(rating);
            }
            dismiss();
        });

        return view;
    }
}
