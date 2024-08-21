package com.example.botomappbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.botomappbar.model.User;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = new User();
        user.nombre = "Juan A. A.";
        user.correo = "juan@gmail.com";
        user.contraseña = "123";

        Button botonMain = findViewById(R.id.botonMain);
        botonMain.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userDesdeLogin", new Gson().toJson(user));
            startActivity(intent);
        });
    }
}