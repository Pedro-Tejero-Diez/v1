package com.jump2digital.challenge.v1.repository;

import java.util.List;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PlayerSkinRepository extends MongoRepository<PlayerSkin, String> {
    static void savePlayerSkin(PlayerSkin playerskin) {
    }
}
