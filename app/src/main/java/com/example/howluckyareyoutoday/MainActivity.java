package com.example.howluckyareyoutoday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    EditText editTextNumber3;
    ImageView imageView;
    ImageView imageView2;
    int randomNumber;
    int a=0;
    int i = 0;

    public void generateRandomNumbers(){
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
    }


    public void onClickSprawdz(View view){
        int inputNumber = Integer.parseInt(editTextNumber3.getText().toString());
        String message;
        int length = String.valueOf(inputNumber).length();

        if(length==0){
            return;
        }

        if (inputNumber > 20 || inputNumber < 1){
            message = "Liczba z poza zakresu."+ "\n" + "Wpisz liczbę z zakresu 1-20";
        }else if(inputNumber>randomNumber){
            imageView.setVisibility(View.VISIBLE);
            message = "Wpisz mniejszą liczbę";
            a++;
        }else if(inputNumber < randomNumber){
            imageView.setVisibility(View.VISIBLE);
            message = "Wpisz większą liczbę";
            a++;
        }else{
            imageView2.setVisibility(View.VISIBLE);
            message ="Trafiłeś! Graj dalej :)";
            a++;
            i++;
            generateRandomNumbers();
        }
        String scoreNumber = String.valueOf(i);
        String shootsNumber = String.valueOf(a);
        TextView score = findViewById(R.id.numberOfScore);
        score.setText(scoreNumber);
        TextView shoots = findViewById(R.id.numberOfShoots);
        shoots.setText(shootsNumber);
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        generateRandomNumbers();

    }
}