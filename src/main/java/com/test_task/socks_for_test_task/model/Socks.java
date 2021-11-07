package com.test_task.socks_for_test_task.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Socks {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Pls, enter a color")
    private String color;

    @Column(name = "cotton_part")
    @Min(value = 0, message = "bad")
    @Max(value = 100, message = "bad")
    @NotNull(message = "bad")
    private int cottonPart;

    @Min(value = 0, message = "bad")
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return id == socks.id && cottonPart == socks.cottonPart && color.equals(socks.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color);
    }
}
