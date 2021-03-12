package com.clase3.calcu_calorias.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
//autor: ailinaira
@Setter @Getter
public class MealDTO {
    private String name;
    private ArrayList<IngredientsDTO> ingredients;
}
