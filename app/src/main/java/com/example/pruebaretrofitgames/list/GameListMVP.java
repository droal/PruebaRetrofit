package com.example.pruebaretrofitgames.list;

import com.example.pruebaretrofitgames.http.twitchpojos.Game;
import com.example.pruebaretrofitgames.http.twitchpojos.Twitch;

import java.util.List;

public interface GameListMVP {

    interface View{
        void showGameList(List<Game> games);
    }

    interface Presenter{
        void setView(GameListMVP.View view);
        void requestGamesButton();
    }

    interface Model{
        List<Game> getGameList(GameListPresenter.CustomCallback customCallback);
    }
}

