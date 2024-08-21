package com.example.botomappbar.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.botomappbar.model.User;

public class UserViewModel extends ViewModel {

    public MutableLiveData<User> user;

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

}
