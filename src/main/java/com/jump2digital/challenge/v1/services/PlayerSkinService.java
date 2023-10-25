package com.jump2digital.challenge.v1.services;

import java.io.IOException;
import java.util.List;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;

public interface PlayerSkinService {

    public void buySkinById(int skinId) throws IOException;
/*
    List<PlayerSkin> getAllPlayerSkin();

    void deletePlayerSkin(String playerSkin_id);

    void savePlayerSkin(PlayerSkin playerSkin);

    List<PlayerSkin> getAllPlayerSkinByPlayer(String player_id);

    // void deletePlayerSkin(String playerSkin_id);

*/
}

