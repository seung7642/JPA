package com.pangtrue.shop.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearch {

    private String memberName;       //회원 이름
    private OrderStatus orderStatus; //주문 상태

    public Specifications<Order> toSpecification() {
        return where(memberNameLike(memberName))
                .and(orderStatusEq(orderStatus));
    }
}
