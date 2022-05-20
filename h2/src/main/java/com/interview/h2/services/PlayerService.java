package com.interview.h2.services;

import com.interview.h2.dto.Player;
import com.interview.h2.dto.PlayerNode;

import java.util.List;
import java.util.Map;

public interface PlayerService {
    Player fetchPlayer(Long id) throws Exception;
    public List<PlayerNode> fetchAllPlayers();

}
