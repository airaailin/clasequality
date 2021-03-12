package com.clase3.calcu_calorias.Controller;


import com.clase3.calcu_calorias.DTOS.MealDTO;
import com.clase3.calcu_calorias.DTOS.ResponseDTO;
import com.clase3.calcu_calorias.Service.ICaloriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//autor: ailinaira
@RestController
public class CaloriesController {

    @Autowired
    private ICaloriesService service;

    //metodo post 
    @PostMapping(path = "/infocalorias")
    public ResponseDTO getResponse(@RequestBody MealDTO meal){
        return service.calculator(meal);
    }

}
