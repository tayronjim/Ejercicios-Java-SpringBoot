package com.javatest.javatest;

import com.javatest.javatest.servicios.IOperaciones;
import com.javatest.javatest.servicios.Operaciones;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OperacionesTest {
    private IOperaciones operaciones;

    @BeforeEach
    public void setup(){
        operaciones = new Operaciones();
    }

    @Test
    public void FactorialTest(){
        Assertions.assertEquals(operaciones.factorial(0),1);
        Assertions.assertEquals(operaciones.factorial(1),1);
        Assertions.assertEquals(operaciones.factorial(4),24);
        Assertions.assertEquals(operaciones.factorial(5),120);
        Assertions.assertEquals(operaciones.factorial(10),3628800);
    }

    @Test
    public void FactorilFailTest(){
        Assertions.assertEquals(operaciones.factorial(0),0);
        Assertions.assertThrows(ArithmeticException.class, ()->{
            operaciones.factorial(-1);
        });
        Assertions.assertThrows(ArithmeticException.class, ()->{
            operaciones.factorial(-100);
        });
    }
}
