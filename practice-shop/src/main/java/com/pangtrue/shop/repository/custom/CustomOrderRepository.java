package com.pangtrue.shop.repository.custom;

import com.pangtrue.shop.domain.Order;
import com.pangtrue.shop.domain.OrderSearch;

import java.util.List;

public interface CustomOrderRepository {

    public List<Order> search(OrderSearch orderSearch);
}
