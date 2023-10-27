package com.jump2digital.challenge.v1.testservices;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.repository.PlayerSkinRepository;
import com.jump2digital.challenge.v1.services.PlayerSkinServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlayerSkinServiceImpTest {

    @InjectMocks
    private PlayerSkinServiceImp playerSkinServiceImp;

    @Mock
    private PlayerSkinRepository playerSkinRepository;

    @Test
    public void testBuySkinById() throws IOException {
        // Mock repository behavior
        PlayerSkin playerSkin = new PlayerSkin();
        Mockito.when(playerSkinRepository.save(Mockito.any(PlayerSkin.class))).thenReturn(playerSkin);

        // Call the service method
        playerSkinServiceImp.buySkinById(0);

        // Verify the result
        Mockito.verify(playerSkinRepository).save(Mockito.any(PlayerSkin.class));
    }

    @Test
    public void testUpdatePlayerSkinColor() {
        // Mock repository behavior
        PlayerSkin playerSkin = new PlayerSkin();
        Skin skin = new Skin();
        playerSkin.setPlayerSkin(skin);
        Mockito.when(playerSkinRepository.findById("1")).thenReturn(Optional.of(playerSkin));

        // Call the service method
        PlayerSkin updatedPlayerSkin = playerSkinServiceImp.updatePlayerSkinColor("1", "newColor");

        // Verify the result
        assertEquals("newColor", updatedPlayerSkin.getPlayerSkin().getColor());
        Mockito.verify(playerSkinRepository).save(playerSkin);
    }
}
