package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bio.data.Bio;
import com.example.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // View binding
    private ActivityMainBinding binding;
    // Data binding
    private Bio bio = new Bio();

//    private EditText enterHobbies;
//    private TextView hobbiesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // View binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.doneButton.setOnClickListener(view -> addHobbies(view));
        // Data binding
        bio.setName("Yunna Jang");
        binding.setBio(bio);

//        setContentView(R.layout.activity_main);
//
//        enterHobbies = findViewById(R.id.enterHobbies);
//        hobbiesText = findViewById(R.id.hobbiesText);
    }

    public void addHobbies(View view) {
        // Data binding
        bio.setHobbies(String.format("Hobbies: %s", binding.enterHobbies.getText().toString().trim()));

        // View binding
//        binding.hobbiesText.setText(String.format("Hobbies: %s", binding.enterHobbies.getText().toString().trim()));
        binding.invalidateAll();
        binding.hobbiesText.setVisibility(View.VISIBLE);
//        hobbiesText.setText(String.format("Hobbies: %s", enterHobbies.getText().toString().trim()));
//        hobbiesText.setVisibility(View.VISIBLE);

        // Hide keyboard if we enter done button
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert inputMethodManager != null;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}