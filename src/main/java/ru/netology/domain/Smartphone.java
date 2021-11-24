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
}
