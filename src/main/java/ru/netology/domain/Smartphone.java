package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

public class Smartphone extends Product {
    private String trademark;

    public Smartphone(int id, String name, int price, String trademark) {
        super(id, name, price);
        this.trademark = trademark;
    }

    public Smartphone() {
        super();
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getTrademark().toLowerCase().contains(search.toLowerCase());
        }
    }
}
