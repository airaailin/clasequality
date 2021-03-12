package com.clase3.calcu_calorias.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter @Getter
public class PlatoDTO {
    private String nombre;
    private ArrayList<IngredientesDTO> ingredientes;
}
