
package com.yoprogramo.allinone.networkservices.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Top implements Serializable {

    @SerializedName("channels")
    @Expose
    private Integer channels;
    @SerializedName("viewers")
    @Expose
    private Integer viewers;
    @SerializedName("game")
    @Expose
    private Game game;

    public Integer getChannels() {
        return channels;
    }

    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    public Integer getViewers() {
        return viewers;
    }

    public void setViewers(Integer viewers) {
        this.viewers = viewers;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
