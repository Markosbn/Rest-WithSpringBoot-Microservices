package com.schulzmarcos.api.resources;

import com.schulzmarcos.domain.services.ConverterService;
import com.schulzmarcos.domain.services.converterService;
import com.schulzmarcos.domain.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    MathService service;
    @Autowired
    ConverterService converterService;

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!converterService.isNumeric(numberOne) || !converterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double sum = service.sum(converterService.convertToDouble(numberOne), converterService.convertToDouble(numberTwo));
        return sum;
    }


    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!converterService.isNumeric(numberOne) || !converterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double subtraction = service.subtraction(converterService.convertToDouble(numberOne), converterService.convertToDouble(numberTwo));
        return subtraction;
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!converterService.isNumeric(numberOne) || !converterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double multiplication = service.multiplication(converterService.convertToDouble(numberOne), converterService.convertToDouble(numberTwo));
        return multiplication;
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!converterService.isNumeric(numberOne) || !converterService.isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double division = service.division(converterService.convertToDouble(numberOne), converterService.convertToDouble(numberTwo));
        return division;
    }

    @GetMapping("/average/{numberOne}/{numberTwo}/{numberThree}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("numberThree") String numberThree){
        if (!converterService.isNumeric(numberOne) || !converterService.isNumeric(numberTwo) || !converterService.isNumeric(numberThree)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double average = service.average(converterService.convertToDouble(numberOne), converterService.convertToDouble(numberTwo), converterService.convertToDouble(numberThree));
        return average;
    }

    @GetMapping("/mathSquare/{numberOne}")
    public Double mathSquare(@PathVariable("numberOne") String numberOne){
        if (!converterService.isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double mathSquare = service.mathSquare(converterService.convertToDouble(numberOne));
        return mathSquare;
    }
}
