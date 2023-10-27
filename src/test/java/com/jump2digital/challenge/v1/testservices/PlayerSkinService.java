package com.jump2digital.challenge.v1.testservices;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.services.PlayerSkinService;
import com.jump2digital.challenge.v1.repository.PlayerSkinRepository;
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
class PlayerSkinServiceTest {

    @InjectMocks
    private PlayerSkinService playerSkinService;

    @Mock
    private PlayerSkinRepository playerSkinRepository;

    @Test
    public void testBuySkinById() throws IOException {
        // Mock repository behavior
        PlayerSkin playerSkin = new PlayerSkin();
        Mockito.when(playerSkinRepository.save(playerSkin)).thenReturn(playerSkin);

        // Call the service method
        playerSkinService.buySkinById(0);

        // Verify the result
        Mockito.verify(playerSkinRepository).save(playerSkin);
    }

    @Test
    public void testGetAllPlayerSkin() {
        // Mock repository behavior
        List<PlayerSkin> playerSkins = List.of(new PlayerSkin(), new PlayerSkin());
        Mockito.when(playerSkinRepository.findAll()).thenReturn(playerSkins);

        // Call the service method
        List<PlayerSkin> result = playerSkinService.getAllPlayerSkin();

        // Verify the result
        assertEquals(playerSkins, result);
    }

    @Test
    public void testGetPlayerSkinById() {
        // Mock repository behavior
        PlayerSkin playerSkin = new PlayerSkin();
        Mockito.when(playerSkinRepository.findById("1")).thenReturn(Optional.of(playerSkin));

        // Call the service method
        Optional<PlayerSkin> result = playerSkinService.getPlayerSkinById("1");

        // Verify the result
        assertEquals(Optional.of(playerSkin), result);
    }
}
