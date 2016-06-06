package com.example.calculadora;

/**
 * Created by davidgonzalez on 05/06/2016.
 */
public class Calculadora implements ICalculadora {
    @Override
    public Long suma(Long input1, Long input2) throws ValidationException {
        if (input1 == null || input2 == null) {
            throw new ValidationException("Los sumandos no pueden ser nulos");
        }
        return input1 + input2;
    }

    @Override
    public Long divide(Long dividendo, Long divisor) throws ValidationException {
        if (dividendo == null || divisor == null) {
            throw new ValidationException("Los parametros no pueden ser nulos");
        }
        if (divisor == 0) {
            throw new ValidationException("No se puede dividir por cero");
        }
        return dividendo / divisor;
    }
}
