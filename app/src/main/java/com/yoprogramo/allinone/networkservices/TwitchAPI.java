package com.yoprogramo.allinone.networkservices;

import com.yoprogramo.allinone.networkservices.model.Twitch;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface TwitchAPI {
    @Headers({
            "Accept: application/vnd.twitchtv.v5+json",
            "Client-ID: 3h02u5orzmt5hf183k4dhz6rfocos3"})
    @GET("games/top")
    Call<Twitch> getTopGames();


    @Headers({
            "Accept: application/vnd.twitchtv.v5+json",
            "Client-ID: 3h02u5orzmt5hf183k4dhz6rfocos3"})
    @GET("games/top")
    Observable<Twitch> getTopGamesObservable();

}
