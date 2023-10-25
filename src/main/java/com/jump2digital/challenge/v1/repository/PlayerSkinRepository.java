package com.jump2digital.challenge.v1.repository;

import java.util.List;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PlayerSkinRepository extends MongoRepository<PlayerSkin, String> {

    @Query("{ 'player' : {'$oid' : ?0}}")
    List<PlayerSkin> findAllByPlayer_id(String player_id);
}
