package com.example.demo.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player getPlayer(String nickName) throws Exception{
        Optional<Player> player = playerRepository.findById(nickName);
        if(player.isPresent()){
            return player.get();
        }
        throw new Exception("User not fodund");
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public int getLevelPlayer(String nickName) throws Exception{
        Player player = getPlayer(nickName);
        return player.getLevel();
    }

    public void deletePlayer(String nickName) throws Exception{
        Player player = getPlayer(nickName);
        playerRepository.delete(player);
    }

    public String getEmail(String nickName) throws Exception{
        Player player = getPlayer(nickName);
        return player.getEmail();
    }

    public String getNickName(Player player){
        return player.getNickName();
    }

    public void updatePlayer(Player player, String email, int level){
        player.setEmail(email);
        player.setLevel(level);
        playerRepository.save(player);
    }    

    public void updatePlayer(String nickName, String email, int level) throws Exception{
        Player player = getPlayer(nickName);
        player.setEmail(email);
        player.setLevel(level);
        playerRepository.save(player);
    } 

    public Player createPlayer(String nickName, String email){
        Player player = new Player(nickName, email, 0);
        return player;
    }

}
