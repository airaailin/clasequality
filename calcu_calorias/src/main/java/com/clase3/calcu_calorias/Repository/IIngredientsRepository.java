package com.clase3.calcu_calorias.Repository;

import com.clase3.calcu_calorias.DTOS.CaloriesDTO;
//autor: ailinaira
public interface IIngredientsRepository {
    CaloriesDTO getIngredientCalories(String ingredient);
}
