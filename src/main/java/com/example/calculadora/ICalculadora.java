package com.example.calculadora;

/**
 * Created by davidgonzalez on 05/06/2016.
 */
public interface ICalculadora {
    Long suma(Long input1, Long input2) throws ValidationException;
    Long divide(Long dividendo, Long divisor) throws ValidationException;
}
