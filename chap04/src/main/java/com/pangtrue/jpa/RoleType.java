package com.pangtrue.jpa;

import lombok.AllArgsConstructor;

/**
 * User: Seungho Lee ( seung7642@gmail.com )
 * Date: 2020.05.17
 * Time: 15:30
 */
@AllArgsConstructor
public enum RoleType {

    ADMIN(0),
    USER(1);

    private Integer value;
}
