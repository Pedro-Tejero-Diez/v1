package com.jump2digital.challenge.v1.testrepository;

import com.jump2digital.challenge.v1.TestMongoConfig;
import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.repository.PlayerSkinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = TestMongoConfig.class)
class PlayerSkinRepositoryTest {

    @Autowired
    private PlayerSkinRepository playerSkinRepository;

    @Test
    public void testSavePlayerSkin() {
        // Create a PlayerSkin object
        PlayerSkin playerSkin = new PlayerSkin();
        playerSkin.setPlayer_skin_id("testId");
        playerSkin.setRegdate(LocalDate.now());

        // Save the PlayerSkin using the repository
        playerSkinRepository.save(playerSkin);

        // Fetch the saved PlayerSkin from the repository
        Optional<PlayerSkin> savedPlayerSkin = playerSkinRepository.findById("testId");

        // Verify if the saved PlayerSkin matches the one we saved
        assertEquals(playerSkin, savedPlayerSkin.orElse(null));
    }
}

