package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;
    
    @GetMapping("/prueba")
    public String prueba() {
        return "hola";
    }

    @GetMapping("/get/player")
    @ResponseBody
    public Player getplayer(@RequestParam String nickName) {
        try {
            return playerService.getPlayer(nickName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/get/allplayers")
    @ResponseBody
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
    
    @GetMapping("/get/level")
    public int getLevelPlayer(@RequestParam String nickName) {
        try {
            return playerService.getLevelPlayer(nickName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    @DeleteMapping("/delete/player/{nickName}")
    public void deletePlayer(@PathVariable String nickName) {
        try {
            playerService.deletePlayer(nickName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @GetMapping("/get/email")
    public String getEmail(@RequestParam String nickName) {
        try {
            return playerService.getEmail(nickName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @GetMapping("/get/nicname")
    public String getNickName(@RequestBody Player player) {
        return playerService.getNickName(player);
    }

    @PutMapping("/update/player")
    public void updatePlayer(@RequestBody Player player, @RequestParam String email, @RequestParam int level) {
        playerService.updatePlayer(player, email, level);
    }

    @PutMapping("/update/player/{nickname}")
    public void updatePlayer(@PathVariable String nickName, @RequestParam String email, @RequestParam int level) {
        try {
            playerService.updatePlayer(nickName, email, level);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
