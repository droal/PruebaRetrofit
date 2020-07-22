package com.example.pruebaretrofitgames.list;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.pruebaretrofitgames.http.TwitchAPIService;
import com.example.pruebaretrofitgames.http.twitchpojos.Game;
import com.example.pruebaretrofitgames.http.twitchpojos.Twitch;
import com.example.pruebaretrofitgames.root.App;
import com.example.pruebaretrofitgames.root.ApplicationComponent;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TwitchApiRepository extends App implements GameListRepository {

    @Inject
    TwitchAPIService twitchAPIService;

    ApplicationComponent component;
    SharedPreferences sharedPreferences;

    public TwitchApiRepository(ApplicationComponent component, Context context) {
        this.component = component;
        component.inject(this);
        this.sharedPreferences = context.getSharedPreferences("AppPref", Context.MODE_PRIVATE);
    }



    @Override
    public List<Game> getGamesList(GameListPresenter.CustomCallback customCallback) {

        List<Game> topGames = null;

        String token = sharedPreferences.getString("token", "");

        Call<Twitch> call = twitchAPIService.getTopGames("Bearer "+token, "tuev4s9hwme3ddcgvogj1psrk0h3qp");


        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                if(response.isSuccessful()){
                    customCallback.onSucess(response.body().getGame());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return null;
    }
}
