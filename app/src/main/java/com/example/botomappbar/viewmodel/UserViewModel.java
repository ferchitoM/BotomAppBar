package com.example.botomappbar.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botomappbar.model.User;

public class UserViewModel extends ViewModel {

    public MutableLiveData<User> user;
    public MutableLiveData<String> text;

    public MutableLiveData<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        if(this.user == null) {
            this.user = new MutableLiveData<>();
            this.user.setValue(user);
        }
    }

    public void actualizarUser(User user) {
        this.user.setValue(user);
    }

    public void actualizarContraseña(String nuevaContraseña){
        this.user.getValue().cambiarContaseñaDB(nuevaContraseña);

        //Después de cambiar la contraseña en la BD
        this.user.setValue(this.user.getValue());
    }

}
