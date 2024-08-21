package com.example.botomappbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.botomappbar.fragments.BuscarFragment;
import com.example.botomappbar.fragments.CompartirFragment;
import com.example.botomappbar.fragments.DescargarFragment;
import com.example.botomappbar.fragments.EliminarFragment;
import com.example.botomappbar.model.User;
import com.example.botomappbar.viewmodel.UserViewModel;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private TextView toolbarTitle;
    private ImageButton menuButton;
    private BottomAppBar bottomAppBar;
    private BottomNavigationView bottomNavigationView;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String data = intent.getStringExtra("userDesdeLogin");
        User user = new Gson().fromJson(data, User.class);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.setUser(user);


        configurarActivity();

    }

    private void configurarActivity() {

        // Configurar barra de herramientas
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        // Configurar título de la barra de herramientas
        toolbarTitle = findViewById(R.id.toolbar_title);
        //toolbarTitle.setText(R.string.app_name);

        // Configurar botón de menú de la barra de herramientas
        menuButton = findViewById(R.id.boton_bar_menu);
        menuButton.setOnClickListener(v -> {
            showPopUp(v);
        });

        // Configurar barra inferior
        bottomAppBar = findViewById(R.id.bottom_appbar);
        setSupportActionBar(bottomAppBar);

        // Configurar navegación en la barra inferior
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener((MenuItem item) -> {

            if(item.getItemId() == R.id.botonBuscar)
                replaceFragment(new BuscarFragment());
            if(item.getItemId() == R.id.botonEliminar)
                replaceFragment(new EliminarFragment());
            if(item.getItemId() == R.id.botonDescargar)
                replaceFragment(new DescargarFragment());
            if(item.getItemId() == R.id.botonCompartir)
                replaceFragment(new CompartirFragment());

            return true;
        });

        replaceFragment(new BuscarFragment());
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    protected void showPopUp(View v) {
        PopupMenu popupMenu = new PopupMenu(MainActivity.this, v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Configurar acciones para los elementos del menú emergente
        popupMenu.setOnMenuItemClickListener((MenuItem item) -> {
            // Lógica para manejar las acciones de los elementos del menú emergente
            Toast.makeText(MainActivity.this, "Has seleccionado " + item.getTitle(), Toast.LENGTH_SHORT).show();
            return true;
        });

        // Mostrar el menú emergente
        popupMenu.show();
    }
}