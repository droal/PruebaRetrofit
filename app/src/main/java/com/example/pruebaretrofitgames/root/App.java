package com.example.pruebaretrofitgames.root;


/**Logica de la clase Apliccation*/

import android.app.Application;

import com.example.pruebaretrofitgames.http.TwitchModule;
import com.example.pruebaretrofitgames.list.GameListModule;
import com.example.pruebaretrofitgames.login.LoginModule;

/**Acá se declaran los modulos que requiere la aplicación*/
public class   App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .twitchModule(new TwitchModule())
                .gameListModule(new GameListModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
