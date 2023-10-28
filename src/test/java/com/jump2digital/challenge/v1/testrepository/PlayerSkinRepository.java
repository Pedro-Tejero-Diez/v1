package com.jump2digital.challenge.v1.testrepository;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.repository.PlayerSkinRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PlayerSkinRepositoryTest {

    @Autowired
    private PlayerSkinRepository playerSkinRepository;

    @Test
    public void testSavePlayerSkin() {
        // Create a Skin object
        Skin skin = new Skin();
        skin.setId(1);
        skin.setName("Test Skin");
        skin.setDescription("Test Description");
        skin.setAuthor("Test Author");
        skin.setPrice(10);
        skin.setColor("Test Color");
        // Create a PlayerSkin object
        PlayerSkin playerSkin = new PlayerSkin();
        playerSkin.setPlayer_skin_id("testId");
        playerSkin.setPlayerSkin(skin);
        playerSkin.setRegdate(LocalDate.now());

        // Save the PlayerSkin using the repository
        playerSkinRepository.save(playerSkin);

        // Fetch the saved PlayerSkin from the repository
        PlayerSkin savedPlayerSkin = playerSkinRepository.findById("testId").get();

        // Verify if the saved PlayerSkin matches the one we saved
        assertEquals("testId", savedPlayerSkin.getPlayer_skin_id());
        assertEquals(10, savedPlayerSkin.getPlayerSkin().getPrice());

    }
}

