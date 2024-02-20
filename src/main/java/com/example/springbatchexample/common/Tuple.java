package com.example.springbatchexample.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

@Getter
@Setter
@AllArgsConstructor
public class Tuple<T, K> {

    private final T first;
    private final K second;

    public static Tuple<String,String> build(String[] items){
        Assert.notNull(items, "'items' can not be null");
        Assert.isTrue(items.length == 2,"'items' must have 2 items");
        return new Tuple<>(items[0], items[1]);
    }

}
