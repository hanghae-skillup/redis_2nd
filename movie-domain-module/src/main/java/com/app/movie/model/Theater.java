package com.app.movie.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Theater {

    private Long id;
    private String name;

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Theater) {
            return id.equals(((Theater)obj).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
