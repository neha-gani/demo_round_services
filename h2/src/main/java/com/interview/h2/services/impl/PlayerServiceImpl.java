package com.interview.h2.services.impl;

import com.interview.h2.dao.PlayerRepository;
import com.interview.h2.dto.Player;
import com.interview.h2.dto.PlayerNode;
import com.interview.h2.services.PlayerService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Getter @Setter
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Override
    public Player fetchPlayer(Long id) throws Exception {
        Optional<com.interview.h2.dao.Player> player = repository.findById(id);

        if(player.isEmpty())
            throw new Exception(); //TODO Add custom not found exception
        //TODO add controllerAdvice

        return convertToDto(player.get());

    }

    Player convertToDto(com.interview.h2.dao.Player playerDao){
        return Player.builder().id(playerDao.getId())
                .color(playerDao.getColor())
                .name(playerDao.getName())
                .parentId(playerDao.getParentId()).build();
    }

    @Override
    public List<PlayerNode> fetchAllPlayers() {
        List<com.interview.h2.dao.Player> players = repository.findAll();

        Map<Long, Integer> idToIndex = new HashMap<>();
        ArrayList<PlayerNode> res = new ArrayList<>();
        ArrayList<PlayerNode> playerNodes = new ArrayList<>();

        for (int i = 0; i < players.size(); i += 1) {
            idToIndex.put(players.get(i).getId(),  i);

            PlayerNode player = mapPlayerDaoToNode(players.get(i));
            playerNodes.add(player);
        }

        playerNodes.forEach(
                node -> {
                    if (node.getParentId() != 0) {
                        //child
                        playerNodes.get( idToIndex.get(node.getParentId())).getSubClasses().add(node);

                    }
                    else{
                        // parent
                        res.add(node);
                    }
                }
        );
        return res;
    }

    private PlayerNode mapPlayerDaoToNode(com.interview.h2.dao.Player currentDtoPlayer) {
        return PlayerNode.builder()
                .id(currentDtoPlayer.getId())
                .name(currentDtoPlayer.getName())
                .parentId(currentDtoPlayer.getParentId())
                .subClasses(new ArrayList<>())
                .build();
    }
}
