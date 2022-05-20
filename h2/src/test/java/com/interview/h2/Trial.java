package com.interview.h2;

import com.interview.h2.dto.Player;
import com.interview.h2.dto.PlayerNode;

import java.util.*;

public class Trial {

//    const arr = [
//    {
//        "id": "12",
//            "parentId": "0",
//            "text": "Man",
//            "level": "1",
//            "children": null
//    },
//    {
//        "id": "6",
//            "parentId": "12",
//            "text": "Boy",
//            "level": "2",
//            "children": null
//    },
//    {
//        "id": "7",
//            "parentId": "12",
//            "text": "Other",
//            "level": "2",
//            "children": null
//    },
//    {
//        "id": "9",
//            "parentId": "0",
//            "text": "Woman",
//            "level": "1",
//            "children": null
//    },
//    {
//        "id": "11",
//            "parentId": "9",
//            "text": "Girl",
//            "level": "2",
//            "children": null
//    }
//];
    ArrayList<PlayerNode> listToTree(ArrayList<com.interview.h2.dto.Player> allPayers) {

        Map<com.interview.h2.dto.Player, List<com.interview.h2.dto.Player>> mappedPlayers = new HashMap<>();
        Map<Long, Integer> idToIndex = new HashMap<>();
        ArrayList<PlayerNode> res = new ArrayList<>();
        ArrayList<PlayerNode> playerNodes = new ArrayList<>();

        for (int i = 0; i < allPayers.size(); i += 1) {
            idToIndex.put(allPayers.get(i).getId(),  i);

            allPayers.get(i).setChildPlayers(new ArrayList<>());
//            playerNodes.add(mapPlayerDaoToNode(allPayers.get(i)));
        };

        allPayers.forEach(
                node -> {
                    if (node.getParentId() == 0) {
                        //parent
                        res.add(mapPlayerDaoToNode(node));
//                        mappedPlayers.putIfAbsent(currentDtoPlayer, new ArrayList<>());
//                        idToPlayer.putIfAbsent(currentDtoPlayer.getId(), currentDtoPlayer);
                    }
                    else{ //child

                       allPayers.get( idToIndex.get(node.getParentId())).getChildPlayers().add(node);
//                        Player parentPlayer = idToPlayer.get(currentDtoPlayer.getParentId());
//                        mappedPlayers.get(parentPlayer.getId()).add(currentDtoPlayer);
                    }
                }
        );
//        for (i = 0; i < arr.length; i += 1) {
//            node = arr[i];
//            if (node.parentId !== "0") {
//                arr[map[node.parentId]].children.push(node);
//            }
//            else {
//                res.push(node);
//            };
//        };
        return res;
    }

    private PlayerNode mapPlayerDaoToNode(Player currentDtoPlayer) {
        PlayerNode playerNode = PlayerNode.builder()
                .id(currentDtoPlayer.getId())
                .name(currentDtoPlayer.getName())
                .subClasses(new ArrayList<>())
                .build();
        return playerNode;
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Kal");
        names.add("Syl");names.add("Jasnah");names.add("Shallan");
//        List<String> names = List.of("Kal", "Syl", "Jasnah", "Shallan");
        System.out.println(names);
       Collections.sort(names, Collections.reverseOrder());
        System.out.println(names);

    }
}
