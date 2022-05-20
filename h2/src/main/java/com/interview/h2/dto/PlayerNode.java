package com.interview.h2.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties(value = { "parentId" , "id"})
public class PlayerNode {
    private String name;
    private Long id;
    private Long parentId;
    private List<PlayerNode> subClasses = new LinkedList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerNode that = (PlayerNode) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
