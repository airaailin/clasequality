package com.clase3.calcu_calorias.DTOS;

import lombok.Getter;
import lombok.Setter;
//autor: ailinaira
@Setter @Getter
public class CaloriesDTO {
    private String name;
    private double calories;

    @Override
    public String toString(){
        return this.getName();
    }
}
