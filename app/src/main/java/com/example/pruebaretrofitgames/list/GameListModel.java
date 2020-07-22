package com.example.pruebaretrofitgames.list;

import com.example.pruebaretrofitgames.http.twitchpojos.Game;

import java.util.List;

public class GameListModel implements GameListMVP.Model {

    private GameListRepository gameListRepository;

    public GameListModel(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }



    @Override
    public List<Game> getGameList(GameListPresenter.CustomCallback customCallback) {
        return gameListRepository.getGamesList(customCallback);
    }
}
