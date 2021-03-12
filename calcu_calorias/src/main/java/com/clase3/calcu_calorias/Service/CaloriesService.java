package com.clase3.calcu_calorias.Service;

import com.clase3.calcu_calorias.DTOS.IngredientsDTO;
import com.clase3.calcu_calorias.DTOS.MealDTO;
import com.clase3.calcu_calorias.DTOS.ResponseDTO;
import com.clase3.calcu_calorias.Repository.IIngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
//autor: ailinaira
@Service
public class CaloriesService implements ICaloriesService {
    @Autowired
    private IIngredientsRepository repository;

    @Override
    public ResponseDTO calculator(MealDTO meal) {
        ResponseDTO response = new ResponseDTO();

        response.setMealCalories(this.mealCalories(meal));
        response.setIngredientCalories(this.IngredientCalories(meal));
        response.setHighestCalorieIngredient(this.HighestCalorieIngredient(meal));

        return response;
    }

    //metodo que calcula la cantidad de calorias de un plato teniendo en cuenta
    //sus ingredientes y el peso
    public double mealCalories(MealDTO meal){
        double mealCalories = 0;
        for (IngredientsDTO i: meal.getIngredients()){
            mealCalories+= i.getWeight() * repository.getIngredientCalories(i.getName()).getCalories()/100;
        }
        return mealCalories;
    }

    //metodo que calcula las calorias de cada ingrediente perteneciente a la comida
    public HashMap<String, Double> IngredientCalories(MealDTO meal){
        HashMap <String, Double> IngredientCalories = new HashMap<String, Double>();
        for (IngredientsDTO i: meal.getIngredients()) {
            IngredientCalories.put(i.getName(), i.getWeight() * repository.getIngredientCalories
                    (i.getName()).getCalories() / 100);
        }
        return IngredientCalories;

    }

    //metodo que obtiene el ingrediente del plato que tiene mas calorias
    public IngredientsDTO HighestCalorieIngredient(MealDTO meal){
        double caloriesOfHighestCalorieIngredient = 0;
        IngredientsDTO highestCalorieIngredient = null;
        for (IngredientsDTO i: meal.getIngredients()){
            if(i.getWeight() * repository.getIngredientCalories
                    (i.getName()).getCalories() / 100 > caloriesOfHighestCalorieIngredient){
                caloriesOfHighestCalorieIngredient = (i.getWeight() * repository.getIngredientCalories
                        (i.getName()).getCalories() / 100);
                highestCalorieIngredient = i;
            }
        }
        return highestCalorieIngredient;
    }

}
