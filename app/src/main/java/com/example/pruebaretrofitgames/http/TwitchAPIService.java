package com.example.pruebaretrofitgames.http;

import com.example.pruebaretrofitgames.http.twitchpojos.TokenResponse;
import com.example.pruebaretrofitgames.http.twitchpojos.Twitch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**En esta interfaz se declaran todos los métodos de consumo de la API Rest*/
public interface TwitchAPIService {



    //Mediante anotaciones se declara el verbo y el end point
    //Con el método Call se indica el tipo de respuesta esperado
    @GET("games/top")
    Call<Twitch> getTopGames(@Header("Authorization") String authorization, @Header("Client-ID") String clientId);
}
