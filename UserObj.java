package com.example.HealthPointUSM;

public class UserObj {
    String Name;
    String Matriks;
    String Email;
    String Password;

    public UserObj(String name, String matriks, String email, String password) {
        Name = name;
        Matriks = matriks;
        Email = email;
        Password = password;
    }

    public UserObj() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMatriks() {
        return Matriks;
    }

    public void setMatriks(String matriks) {
        Matriks = matriks;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
