package com.clase3.calcu_calorias.Service;

import com.clase3.calcu_calorias.DTOS.MealDTO;
import com.clase3.calcu_calorias.DTOS.ResponseDTO;
//autor: ailinaira
public interface ICaloriesService {
    ResponseDTO calculator(MealDTO meal);
}
