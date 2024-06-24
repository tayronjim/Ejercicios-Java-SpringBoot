package com.javatest.javatest.servicios;

import com.javatest.javatest.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {
    public void saveOrder(List<Producto> producto);
}
