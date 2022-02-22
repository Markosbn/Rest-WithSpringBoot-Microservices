package com.schulzmarcos.domain.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

    public double sum(double firstNumber, double secondNumber){
        return firstNumber + secondNumber;
    }

    public double subtraction(double firstNumber, double secondNumber){
        return firstNumber - secondNumber;
    }

    public double multiplication(double firstNumber, double secondNumber){
        return firstNumber * secondNumber;
    }

    public double division(double firstNumber, double secondNumber){
        return firstNumber / secondNumber;
    }

    public double average(double firstNumber, double secondNumber, double thirdNumber){
        return firstNumber + secondNumber + thirdNumber / 3;
    }

    public double mathSquare(double firstNumber){
        return Math.sqrt(firstNumber);
    }



}
