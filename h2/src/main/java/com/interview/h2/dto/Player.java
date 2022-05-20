package com.interview.h2.dto;

import com.googlecode.jmapper.annotations.JGlobalMap;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter @Setter
@JGlobalMap
@Builder
public class Player {

    private Long id;
    private Long parentId;
    private String name;
    private String color;
    private List<Player> childPlayers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
