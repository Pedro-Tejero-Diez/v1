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

    @GetMapping("getskin/{skin_id}")
    public String playerskinsscreen(@PathVariable("player_skin_id") String id,
                                    Model model) {
        Optional<PlayerSkin> playerskin = playerskinservice.getPlayerSkinById(id);
        if (playerskin.isPresent()) {
        model. addAttribute("playerskin",playerskin);
        model.addAttribute("skin", playerskin.get().getPlayerSkin());
        return "playerskin";
    } else return "not_found";
    }

/*
}

        @GetMapping("/myskins")
        public String playerSkins(@PathVariable(value = "player_id")
                                  String player_id, Model model) {

            try {
                List<PlayerSkin> playerskin.html = playerskinservice
                        .getAllPlayerSkinByPlayer(player_id);

                    model.addAttribute("playerskin.html", playerskin.html);

                    return "player";
                } else
                    return "no_encontrado";
            } catch (Exception e) {
                return "error";
            }
        }
    }


    // esto es el redirect que use para hacer una nueva jugada y guardarla
     * @PostMapping("/{player_id}/myskins")
    public String playerSkins(@PathVariable(value = "player_id") String player_id,
                              RedirectAttributes ra, Model model) {

            if (service.getPlayerById(player_id)!=null) {
                List<PlayerSkin> playerskin.html =  playerskinservice
                		.getAllPlayerSkinByPlayer(player_id);
            ra.addFlashAttribute("playerskin.html",playerskin.html);
            return "redirect:/Skins/{player_id}/playerskins";
            } else return "error";

    }*/

}
