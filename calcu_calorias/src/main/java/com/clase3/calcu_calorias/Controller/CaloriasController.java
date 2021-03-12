package com.clase3.calcu_calorias.Controller;


import com.clase3.calcu_calorias.DTOS.PlatoDTO;
import com.clase3.calcu_calorias.DTOS.RespuestaDTO;
import com.clase3.calcu_calorias.Service.ICaloriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaloriasController {

    @Autowired
    private ICaloriasService service;

    @PostMapping(path = "/infocalorias")
    public RespuestaDTO crearRespuesta(@RequestBody PlatoDTO plato){
        return service.calculadora(plato);
    }

}
