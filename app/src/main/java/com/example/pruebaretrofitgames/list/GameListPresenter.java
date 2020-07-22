package com.example.pruebaretrofitgames.list;

import androidx.annotation.Nullable;

import com.example.pruebaretrofitgames.http.twitchpojos.Game;

import java.util.List;


public class GameListPresenter implements GameListMVP.Presenter{

    @Nullable
    private GameListMVP.View view;
    private GameListMVP.Model model;

    public GameListPresenter(GameListMVP.Model  model) {
        this.model = model;
    }

    @Override
    public void setView(GameListMVP.View view) {
        this.view = view;
    }


    public interface CustomCallback {
        void onSucess( List<Game> topGames );
        void onFailure();
    }


    @Override
    public void requestGamesButton() {
            if (view != null){
                List<Game> games = model.getGameList(new CustomCallback() {
                    @Override
                    public void onSucess(List<Game> topGames) {
                        view.showGameList(topGames);
                    }

                    @Override
                    public void onFailure() {

                    }
                });
            }
    }
}
