package com.schulzmarcos.api.resources;

import com.schulzmarcos.domain.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    MathService service;

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!service.isNumeric(numberOne) || !service.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double sum = service.convertToDouble(numberOne) + service.convertToDouble(numberTwo);
        return sum;
    }


    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!service.isNumeric(numberOne) || !service.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double subtraction = service.convertToDouble(numberOne) - service.convertToDouble(numberTwo);
        return subtraction;
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!service.isNumeric(numberOne) || !service.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double multiplication = service.convertToDouble(numberOne) * service.convertToDouble(numberTwo);
        return multiplication;
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!service.isNumeric(numberOne) || !service.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double division = service.convertToDouble(numberOne) / service.convertToDouble(numberTwo);
        return division;
    }

    @GetMapping("/average/{numberOne}/{numberTwo}/{numberThree}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("numberThree") String numberThree){
        if (!service.isNumeric(numberOne) || !service.isNumeric(numberTwo) || !service.isNumeric(numberThree)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double average = (service.convertToDouble(numberOne) + service.convertToDouble(numberTwo) + service.convertToDouble(numberThree)) / 3;
        return average;
    }

    @GetMapping("/mathSquare/{numberOne}")
    public Double mathSquare(@PathVariable("numberOne") String numberOne){
        if (!service.isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double mathSquare = Math.sqrt(service.convertToDouble(numberOne));
        return mathSquare;
    }
}
