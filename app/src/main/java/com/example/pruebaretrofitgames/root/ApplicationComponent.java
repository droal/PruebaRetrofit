package com.example.pruebaretrofitgames.root;


import com.example.pruebaretrofitgames.http.TwitchModule;
import com.example.pruebaretrofitgames.list.GameListModule;
import com.example.pruebaretrofitgames.list.GamesListActivity;
import com.example.pruebaretrofitgames.list.TwitchApiRepository;
import com.example.pruebaretrofitgames.login.LoginActivity;
import com.example.pruebaretrofitgames.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**Determina las dependencias que se van a injectar (Actividades, servicios, fragmentos..)*/
/**Se utiliza para asignar referencias a Actividades, servicios, fragmentos..*/

/**Se indica el modulo del cual depende el componente*/
@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class, TwitchModule.class, GameListModule.class})
public interface ApplicationComponent {

    //Método de inyección
    void inject(LoginActivity target);

    void inject(GamesListActivity gamesListActivity);

    void inject(TwitchApiRepository twitchApiRepository);
}
