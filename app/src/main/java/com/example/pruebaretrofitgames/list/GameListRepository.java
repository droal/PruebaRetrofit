package com.example.pruebaretrofitgames.list;

import com.example.pruebaretrofitgames.http.twitchpojos.Game;

import java.util.List;

public interface GameListRepository {

    List<Game> getGamesList(GameListPresenter.CustomCallback customCallback);

}
