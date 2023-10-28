package com.jump2digital.challenge.v1.testcontrollers;

import com.jump2digital.challenge.v1.controllers.PlayerSkinController;
import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.services.PlayerSkinServiceImp;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class PlayerSkinControllerTest {

    @InjectMocks
    private PlayerSkinController playerSkinController;

    @Mock
    private PlayerSkinServiceImp playerSkinService;

    @Test
    public void testListSkins() throws IOException {
        List<Skin> skins = new ArrayList<>();
        Mockito.when(playerSkinService.readJsonFile()).thenReturn(skins);

        Model model = mock(Model.class);
        String result = playerSkinController.listSkins(model);

        assertEquals("skins", result);
        Mockito.verify(model).addAttribute("skins", skins);
    }

    @Test
    public void testBuySkinPlayer() throws IOException {
        int skinId = 1;
        playerSkinController.buySkinPlayer(String.valueOf(skinId));
        Mockito.verify(playerSkinService).buySkinById(skinId - 1);
    }

    @Test
    public void testGetAllPlayerSkins() {
        List<PlayerSkin> playerSkins = new ArrayList<>();
        Mockito.when(playerSkinService.getAllPlayerSkin()).thenReturn(playerSkins);

        Model model = mock(Model.class);
        String result = playerSkinController.playerskinsscreen(model);

        assertEquals("playerskins", result);
        Mockito.verify(model).addAttribute("playerskins", playerSkins);
    }

    @Test
    public void testGetPlayerSkinById() {
        String playerId = "1";
        PlayerSkin playerSkin = new PlayerSkin();
        Optional<PlayerSkin> optionalPlayerSkin = Optional.of(playerSkin);
        Mockito.when(playerSkinService.getPlayerSkinById(playerId)).thenReturn(optionalPlayerSkin);

        Model model = mock(Model.class);
        String result = playerSkinController.playerskinsscreen(playerId, model);

        assertEquals("playerskin", result);
        Mockito.verify(model).addAttribute("playerskin", playerSkin);
        Mockito.verify(model).addAttribute("skin", playerSkin.getPlayerSkin());
    }

    @Test
    public void testGetPlayerSkinByIdNotFound() {
        String playerId = "1";
        Optional<PlayerSkin> optionalPlayerSkin = Optional.empty();
        Mockito.when(playerSkinService.getPlayerSkinById(playerId)).thenReturn(optionalPlayerSkin);

        Model model = mock(Model.class);
        String result = playerSkinController.playerskinsscreen(playerId, model);

        assertEquals("not_found", result);
        assertTrue(Mockito.mockingDetails(model).getInvocations().isEmpty());
    }
}
