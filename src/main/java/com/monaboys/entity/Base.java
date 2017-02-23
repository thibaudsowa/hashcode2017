package com.monaboys.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lpetit on 23/02/2017.
 */
@Getter
@Setter
@EqualsAndHashCode
public class Base implements IEntity {
    private int id;
    
    public Base(int id) {
        this.id = id;
    }
}
