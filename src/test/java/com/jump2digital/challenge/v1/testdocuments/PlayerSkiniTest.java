package com.jump2digital.challenge.v1.testdocuments;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PlayerSkinTest {

    @Mock
    private Skin skin;

    private PlayerSkin playerSkin;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Create a Skin object
        when(skin.getName()).thenReturn("Test Skin");
        when(skin.getDescription()).thenReturn("Test Description");
        when(skin.getAuthor()).thenReturn("Test Author");
        when(skin.getPrice()).thenReturn(100);
        when(skin.getColor()).thenReturn("Test Color");

        // Create a PlayerSkin object
        playerSkin = new PlayerSkin(skin);
    }

    @Test
    public void testPlayerSkinCreation() {
        assertEquals("Test Skin", playerSkin.getPlayerSkin().getName());
        assertEquals("Test Description", playerSkin.getPlayerSkin().getDescription());
        assertEquals("Test Author", playerSkin.getPlayerSkin().getAuthor());
        assertEquals(100, playerSkin.getPlayerSkin().getPrice());
        assertEquals("Test Color", playerSkin.getPlayerSkin().getColor());
        assertEquals(LocalDate.now(), playerSkin.getRegdate());
    }
}
