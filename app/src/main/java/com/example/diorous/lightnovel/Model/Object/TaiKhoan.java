package com.example.diorous.lightnovel.Model.Object;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Diorous on 12/15/2017.
 */

public class TaiKhoan {
    private static AtomicInteger atomicInteger=new AtomicInteger(0);
    private String id;
    private String Name;
    private String Email;
    private String Username;
    private String Password;
    public TaiKhoan(){
        id="1000"+atomicInteger.incrementAndGet();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
