package com.jump2digital.challenge.v1.testservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.repository.PlayerSkinRepository;
import com.jump2digital.challenge.v1.services.PlayerSkinServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PlayerSkinServiceImpTest {

    @Mock
    private PlayerSkinRepository playerSkinRepository;

    @InjectMocks
    private PlayerSkinServiceImp playerSkinServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReadJsonFile() throws IOException {

        //test that the service is reading the correct file

        // Act
        List<Skin> skins = playerSkinServiceImp.readJsonFile();

        // Assert
        assertEquals(10, skins.size());
        assertEquals(1, skins.get(0).getId());
        assertEquals("Sleek Silver Sentinel", skins.get(0).getName());
        assertEquals(10, skins.get(9).getId());
        assertEquals("Galactic Explorer", skins.get(9).getName());

    }

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
        // Create a Skin object with some initial color
        Skin initialSkin = new Skin();
        initialSkin.setColor("InitialColor");

        // Create a PlayerSkin object
        PlayerSkin playerSkin = new PlayerSkin();
        playerSkin.setPlayer_skin_id("testId");
        playerSkin.setPlayerSkin(initialSkin);

        // Mock the findById method to return the playerSkin when called with "testId"
        Mockito.when(playerSkinRepository.findById("testId")).thenReturn(Optional.of(playerSkin));

        // Mock the save method to return the updated playerSkin
        Mockito.when(playerSkinRepository.save(playerSkin)).thenReturn(playerSkin);

        // Call the service method to update the color
        PlayerSkin updatedPlayerSkin = playerSkinServiceImp.updatePlayerSkinColor("testId", "NewColor");

        // Verify the result
        assertEquals("NewColor", updatedPlayerSkin.getPlayerSkin().getColor());

        // Verify that the save method on the repository is called with the updated playerSkin
        Mockito.verify(playerSkinRepository).save(playerSkin);
    }


    @Test
    public void testUpdatePlayerSkinColor_PlayerSkinNotFound() {
        // Mock the findById method to return an empty Optional, simulating a non-existent playerSkin
        Mockito.when(playerSkinRepository.findById("testId")).thenReturn(Optional.empty());

        // Verify that the service method throws a NoSuchElementException
        assertThrows(NoSuchElementException.class, () -> playerSkinServiceImp.updatePlayerSkinColor("testId", "NewColor"));
    }
}
