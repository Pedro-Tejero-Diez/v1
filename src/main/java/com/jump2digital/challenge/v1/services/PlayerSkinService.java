package com.jump2digital.challenge.v1.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.jump2digital.challenge.v1.documents.PlayerSkin;

public interface PlayerSkinService {

    void buySkinById(int skinId) throws IOException;

    List<PlayerSkin> getAllPlayerSkin();

    Optional<PlayerSkin> getPlayerSkinById(String id);
/*
    void deletePlayerSkin(String playerSkin_id);

    void savePlayerSkin(PlayerSkin playerSkin);

    List<PlayerSkin> getAllPlayerSkinByPlayer(String player_id);

    // void deletePlayerSkin(String playerSkin_id);

*/
}

