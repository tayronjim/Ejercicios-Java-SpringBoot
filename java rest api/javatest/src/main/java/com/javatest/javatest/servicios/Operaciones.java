package com.javatest.javatest.servicios;

import org.springframework.stereotype.Service;

@Service
public class Operaciones implements IOperaciones {
    @Override
    public int factorial(int num) {

        if(num<0) throw new ArithmeticException();
        if (num==1 || num==0) return 1;
        return num * factorial(num-1);
    }
}
