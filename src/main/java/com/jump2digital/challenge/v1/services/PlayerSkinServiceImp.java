package com.jump2digital.challenge.v1.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
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
        Resource resource = new ClassPathResource("json/skins.json");
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

    public PlayerSkin updatePlayerSkinColor(String player_skin_id, String newcolor) {

        PlayerSkin playerSkin = playerskinrepository.findById(player_skin_id)
                .orElseThrow(() -> new NoSuchElementException("PlayerSkin not found"));

        Skin skin = playerSkin.getPlayerSkin();
        skin.setColor(newcolor);

        return playerskinrepository.save(playerSkin);
    }


    public void savePlayerSkin(PlayerSkin playerskin) {
        PlayerSkinRepository.savePlayerSkin(playerskin);
    }

    public void deletePlayerSkin(String player_skin_id) {

        playerskinrepository.deleteById(player_skin_id);
    }
}