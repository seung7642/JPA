package com.pangtrue.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum OrderStatus {
    ORDER(0),
    CANCLE(1);

    @Getter
    @Setter
    private Integer value;
}
