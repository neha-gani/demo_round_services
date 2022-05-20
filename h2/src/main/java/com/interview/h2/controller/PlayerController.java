package com.interview.h2.controller;

import com.interview.h2.dto.Player;
import com.interview.h2.dto.PlayerNode;
import com.interview.h2.services.PlayerService;
import com.interview.h2.utils.LogMethodParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

//    @GetMapping("/")
//    public String sayNihao(){
//        return "Nihao Dungeons and Dragons";
//    }

//    @GetMapping("/")
//    public List<Player> getAll(){
//        return playerService.fetchAllPlayers();
//    }
    @GetMapping("/")
    @LogMethodParam
    public List<PlayerNode> getAll(){
        return playerService.fetchAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getOne(@PathVariable Long id) throws Exception {
        return playerService.fetchPlayer(id);
    }
}
