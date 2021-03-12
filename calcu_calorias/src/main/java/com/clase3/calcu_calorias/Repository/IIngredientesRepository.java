package com.clase3.calcu_calorias.Repository;

import com.clase3.calcu_calorias.DTOS.CaloriasDTO;

public interface IIngredientesRepository {
    CaloriasDTO encontrarCaloriasPorIngrediente(String ingrediente);
}
