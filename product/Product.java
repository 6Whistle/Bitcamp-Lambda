package com.erichgamma.api.product;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class Product {
    private int i;
    private String name;
    private String company;
    private int price;

    @Builder
    public Product(int i, String name, String company, int price){
        this.i = i;
        this.name = name;
        this.company = company;
        this.price = price;
    }
}
