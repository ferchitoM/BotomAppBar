package com.example.botomappbar.model;

public class User {

    public String nombre;
    public String correo;
    public String contraseña;

    public User(){
        this.nombre = "";
        this.correo = "";
        this.contraseña = "";
    }

    public User(String nombre, String correo, String contraseña){
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public void cambiarContaseñaDB(String nuevaContraseña){
        //Supongamos que cambiamos la contraseña en la base de datos
        this.contraseña = nuevaContraseña;
    }
}
