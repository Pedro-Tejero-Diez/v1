package com.jump2digital.challenge.v1.controllers;

import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.services.PlayerSkinServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/skins")
public class PlayerSkinController {

    @Autowired
    PlayerSkinServiceImp playerskinservice;

    @GetMapping("/available")
    public String listSkins(Model model) throws IOException {
        List<Skin> skins = playerskinservice.readJsonFile();
        model.addAttribute("skins", skins);
        model.addAttribute("Skin", new Skin());
        return "skins";
    }

    @PostMapping("/buy")
    public String butSkinPlayer(@RequestParam("skinId") String skinId) throws IOException {
        int skinIdAsInt = Integer.parseInt(skinId);
        playerskinservice.buySkinById(skinIdAsInt - 1);
        return "redirect:/skins/myskins";
    }


    @GetMapping("/myskins")
    public String playerskinsscreen(Model model) {
        List<PlayerSkin> playerskins = playerskinservice.getAllPlayerSkin();
        model.addAttribute("playerskins", playerskins);
        return "playerskins";
    }

    @GetMapping("getskin/{id}")
    public String playerskinsscreen(@PathVariable("id") String id,
                                    Model model) {
        Optional<PlayerSkin> playerskin = playerskinservice.getPlayerSkinById(id);
        if (playerskin.isPresent()) {
            model.addAttribute("playerskin", playerskin.get());
            model.addAttribute("skin", playerskin.get().getPlayerSkin());
            return "playerskin";
        } else return "not_found";
    }
    @GetMapping("color")
    public String getColor(@PathVariable("id") String player_skin_id,
                           @ModelAttribute("NewColor") String newcolor, Model model) {

        playerskinservice.getPlayerSkinById(player_skin_id).get().getPlayerSkin().setColor(newcolor);

        return "playerskins";
    }
    @PostMapping("color/{id}")
    public String changeColor(@PathVariable(value = "player_id")
                              String player_id, Model model) {

        return "color";
    }
    @GetMapping("delete/{id}")
    public String getSkinToDelete(@PathVariable(value = "player_id")
                                    String player_id, Model model) {
        return "delete";
    }
    @DeleteMapping("delete/{id}")
    public String deletePlayerSkins(@PathVariable(value = "player_id")
                                    String player_id, Model model) {
        return "delete";
    }

}