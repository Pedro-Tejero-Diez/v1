package com.jump2digital.challenge.v1.services;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.repository.PlayerSkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class PlayerSkinServiceImp implements PlayerSkinService {

    @Autowired
    PlayerSkinRepository playerskinrepository;

    public List<Skin> readJsonFile() throws IOException {
        Resource resource = new ClassPathResource("skins.json");
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = resource.getInputStream();
        return objectMapper.readValue(inputStream,
                new TypeReference<List<Skin>>() {
                });
    }

    public void buySkinById(int skinId) throws IOException {

        playerskinrepository.save(new PlayerSkin(readJsonFile().get(skinId)));
    }



    @Override
    public List<PlayerSkin> getAllPlayerSkin() {

        return playerskinrepository.findAll();
    }

    @Override
    public Optional<PlayerSkin> getPlayerSkinById(String id) {
        return playerskinrepository.findById(id);

    }
/*
    @Override
    public List<PlayerSkin> getAllPlayerSkinByPlayer(String player_id) {

        return playerskinrepository.findAllByPlayer_id(player_id);
    }

        /*@Override
        public void deletePlayerSkin(String playerSkin_id) {

            Optional<PlayerSkin> playerSkin = playerskinrepository.findById(playerSkin_id);
            if (playerSkin.isPresent()) {

            Optional <Player> player =
                    playerrepository.findById(playerSkin.get().getPlayer().getPlayer_id());

            if (player.isPresent()) {

                Player player1 = player.get();
                for (int i = 0; i<player1.getPlayerSkins().size(); i++) {
                    playerskinrepository.delete(player1.getPlayerSkins().get(i));
                }
            }
            }

        }


    @Override
    public void savePlayerSkin(PlayerSkin playerSkin) {

            /*Player player =
                    playerrepository.findById(playerSkin.getPlayer().getPlayer_id()).get();

            PlayerSkinRepository.save(new PlayerSkin(playerSkin.getRegdate(), player));*/
    }
