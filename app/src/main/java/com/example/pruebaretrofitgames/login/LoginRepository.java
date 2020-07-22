package com.example.pruebaretrofitgames.login;

public interface LoginRepository {
    void saveUser(UserPojo user);

    UserPojo getUser();
}
