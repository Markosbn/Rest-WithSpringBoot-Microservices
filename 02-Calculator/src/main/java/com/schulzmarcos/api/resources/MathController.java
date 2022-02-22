package com.schulzmarcos.api.resources;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
        return sum;
    }


    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double subtraction = convertToDouble(numberOne) - convertToDouble(numberTwo);
        return subtraction;
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double multiplication = convertToDouble(numberOne) * convertToDouble(numberTwo);
        return multiplication;
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
        return division;
    }

    @GetMapping("/average/{numberOne}/{numberTwo}/{numberThree}")
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("numberThree") String numberThree){
        if (!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double average = (convertToDouble(numberOne) + convertToDouble(numberTwo) + convertToDouble(numberThree)) / 3;
        return average;
    }

    @GetMapping("/mathSquare/{numberOne}")
    public Double mathSquare(@PathVariable("numberOne") String numberOne){
        if (!isNumeric(numberOne)){
            throw new UnsupportedOperationException("Please set a numeric value!!");
        }
        Double mathSquare = Math.sqrt(convertToDouble(numberOne));
        return mathSquare;
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
