package com.example.botomappbar.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.botomappbar.R;
import com.example.botomappbar.model.User;
import com.example.botomappbar.viewmodel.UserViewModel;

public class BuscarFragment extends Fragment {

    private View view;
    private TextView title;
    private Button botonActualizar;

    private UserViewModel viewModel;

    public BuscarFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_buscar, container, false);
        title = view.findViewById(R.id.title);
        botonActualizar = view.findViewById(R.id.botonActualizar);

        viewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);

        viewModel.getUser().observe(this, user -> {
            title.setText("Hola " + user.nombre + "... estas en el fragmento buscar");
        });

        botonActualizar.setOnClickListener(v -> {

            User nuevoUsuario = new User();
            nuevoUsuario.nombre = "Camila L. S.";

            viewModel.actualizarUser(nuevoUsuario);
        });

        return view;
    }
}