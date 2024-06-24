package com.javatest.javatest.servicios;
import com.javatest.javatest.models.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OrderService implements IOrderService {

    @Value("${miDataBase.url}")
    String databaseUrl;
    //   la variable databaseUrl se va a llenar con lo que hay en el valor miDataBase.url
    // dicho valor esta almacenado en el archivo application.properties
    // es un equivalente similar a los valores guardados en .dev

    public void saveOrder(List<Producto> producto){
        System.out.print("Producto Guardado en la base de datos: " + databaseUrl);
    }
}
