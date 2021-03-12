package com.clase3.calcu_calorias.DTOS;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CaloriasDTO {
    private String nombre;
    private double calorias;

    @Override
    public String toString(){
        return this.getNombre();
    }
}
