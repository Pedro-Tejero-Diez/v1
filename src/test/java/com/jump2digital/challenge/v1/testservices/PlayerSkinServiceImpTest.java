package com.jump2digital.challenge.v1.testservices;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.repository.PlayerSkinRepository;
import com.jump2digital.challenge.v1.services.PlayerSkinServiceImp;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
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
    public void testReadJsonFile() throws IOException {
       /* // Arrange
        String json = "[{\"id\": 1, \"name\": \"Skin1\"}, {\"id\": 2, \"name\": \"Skin2\"}]";
        InputStream inputStream = new ByteArrayInputStream(json.getBytes());

        Resource resource = Mockito.mock(Resource.class);
        BDDMockito.given(resource.getInputStream()).willReturn(inputStream);

        // Act
        List<Skin> skins = playerSkinServiceImp.readJsonFile();

        // Assert
        assertEquals(2, skins.size());
        assertEquals(1, skins.get(0).getId());
        assertEquals("Skin1", skins.get(0).getName());
        assertEquals(2, skins.get(1).getId());
        assertEquals("Skin2", skins.get(1).getName());

        */
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

        Mockito.when(playerSkinRepository.findById("TestId")).thenReturn(Optional.of(Optional.of(playerSkin).get()));

        // Call the service method
        PlayerSkin updatedPlayerSkin = playerSkinServiceImp.updatePlayerSkinColor("testId", "newColor");

        // Verify the result
        assertEquals("newColor", updatedPlayerSkin.getPlayerSkin().getColor());
        // Verify that the save method on the repository is called with the updated playerSkin
        Mockito.verify(playerSkinRepository).save(playerSkin);
    }
}