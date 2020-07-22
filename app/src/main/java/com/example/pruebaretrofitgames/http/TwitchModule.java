package com.example.pruebaretrofitgames.http;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class TwitchModule {

    public final String URL_BASE = "https://api.twitch.tv/helix/";
    public final String URL_AUTH = "https://id.twitch.tv/";


    @Provides
    public OkHttpClient provideHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build();
    }


    @Provides
    public Retrofit provideRetrofit(String baseUrl, OkHttpClient client){

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public TwitchAPIService provideTwitchService(){
        return provideRetrofit(URL_BASE, provideHttpClient()).create(TwitchAPIService.class);
    }

    @Provides
    public TwitchAuthService provideTwitchAuthService(){
        return provideRetrofit(URL_AUTH, provideHttpClient()).create(TwitchAuthService.class);
    }
}
