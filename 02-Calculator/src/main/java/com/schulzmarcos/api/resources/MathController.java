package com.schulzmarcos.api.resources;

import com.schulzmarcos.domain.services.ConverterService;
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
        if (!ConverterService.isNumeric(numberOne) || !ConverterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double sum = service.sum(ConverterService.convertToDouble(numberOne), ConverterService.convertToDouble(numberTwo));
        return sum;
    }


    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!ConverterService.isNumeric(numberOne) || !ConverterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double subtraction = service.subtraction(ConverterService.convertToDouble(numberOne), ConverterService.convertToDouble(numberTwo));
        return subtraction;
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!ConverterService.isNumeric(numberOne) || !ConverterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double multiplication = service.multiplication(ConverterService.convertToDouble(numberOne), ConverterService.convertToDouble(numberTwo));
        return multiplication;
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!ConverterService.isNumeric(numberOne) || !ConverterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double division = service.division(ConverterService.convertToDouble(numberOne), ConverterService.convertToDouble(numberTwo));
        return division;
    }

    @GetMapping("/average/{numberOne}/{numberTwo}/{numberThree}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("numberThree") String numberThree){
        if (!ConverterService.isNumeric(numberOne) || !ConverterService.isNumeric(numberTwo) || !ConverterService.isNumeric(numberThree)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double average = service.average(ConverterService.convertToDouble(numberOne), ConverterService.convertToDouble(numberTwo), ConverterService.convertToDouble(numberThree));
        return average;
    }

    @GetMapping("/mathSquare/{numberOne}")
    public Double mathSquare(@PathVariable("numberOne") String numberOne){
        if (!ConverterService.isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double mathSquare = service.mathSquare(ConverterService.convertToDouble(numberOne));
        return mathSquare;
    }
}
