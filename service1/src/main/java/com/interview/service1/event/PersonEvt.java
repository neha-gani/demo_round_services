package com.interview.service1.event;

import com.interview.service1.dto.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import java.util.Objects;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class PersonEvt {

    @TargetAggregateIdentifier
    private String id;
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonEvt personEvt = (PersonEvt) o;
        return Objects.equals(id, personEvt.id) && Objects.equals(person, personEvt.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person);
    }
}