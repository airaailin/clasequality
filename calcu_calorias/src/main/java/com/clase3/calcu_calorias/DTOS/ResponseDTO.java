package com.clase3.calcu_calorias.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
//autor: ailinaira
@Setter @Getter
public class ResponseDTO {
    private Double mealCalories;
    private HashMap ingredientCalories;
    private IngredientsDTO highestCalorieIngredient;
}
