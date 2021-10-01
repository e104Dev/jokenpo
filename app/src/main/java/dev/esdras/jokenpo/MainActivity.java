package dev.esdras.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputLayout textInputLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textInputLayout = findViewById(R.id.textInputLayoutContainer);
    }

    public void iniciarJogo(View view) {
        String jogador = Objects.requireNonNull(textInputLayout.getEditText()).getText().toString();
        Intent intent = new Intent(getApplicationContext(), GameActivity.class);
        intent.putExtra("nomeJogador", jogador);
        startActivity(intent);
    }
}