package com.jump2digital.challenge.v1.controllers;

import com.jump2digital.challenge.v1.documents.PlayerSkin;
import com.jump2digital.challenge.v1.documents.Skin;
import com.jump2digital.challenge.v1.services.PlayerSkinServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/skins")
public class PlayerSkinController {

        @Autowired
        PlayerSkinServiceImp playerskinservice;
    //WORKING
        @GetMapping("/available")
        public String listSkins(Model model) throws IOException {
            List<Skin> skins = playerskinservice.readJsonFile();
            model.addAttribute("skins", skins);
            model.addAttribute("Skin", new Skin());
            return "skins";
        }
    @PostMapping("/buy")
    public String butSkinPlayer(@RequestParam ("skinId") String skinId,
                                RedirectAttributes ra) throws IOException {
        int skinIdAsInt = Integer.parseInt(skinId);
        playerskinservice.buySkinById(skinIdAsInt);
        return "redirect:/skins/myskins";
    }


@GetMapping("/myskins")
public String playerskinsscreen(@ModelAttribute("playerskins") List<PlayerSkin> playerskins,
                                Model model) {
    return "playerskins";
}

/*

    @GetMapping("getskin/{skin_id}")
    public String playerskinsscreen(@PathVariable("skin_id") String id,
                                    @ModelAttribute("playerskin") PlayerSkin playerskin,
                                    Model model) {
        return "playerskin";
    }


}

        @GetMapping("/myskins")
        public String playerSkins(@PathVariable(value = "player_id")
                                  String player_id, Model model) {

            try {
                List<PlayerSkin> playerskin = playerskinservice
                        .getAllPlayerSkinByPlayer(player_id);

                    model.addAttribute("playerskin", playerskin);

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
                List<PlayerSkin> playerskin =  playerskinservice
                		.getAllPlayerSkinByPlayer(player_id);
            ra.addFlashAttribute("playerskin",playerskin);
            return "redirect:/Skins/{player_id}/playerskins";
            } else return "error";

    }*/

}
