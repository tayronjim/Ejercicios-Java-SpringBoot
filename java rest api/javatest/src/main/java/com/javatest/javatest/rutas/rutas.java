package com.javatest.javatest.rutas;

import com.javatest.javatest.JavatestApplication;
import com.javatest.javatest.beans.MiBean;
import com.javatest.javatest.beans.MiComponente;
import com.javatest.javatest.models.Lenguajes;
import com.javatest.javatest.models.Libro;
import com.javatest.javatest.models.Producto;
import com.javatest.javatest.models.UserData;
import com.javatest.javatest.servicios.IOrderService;
import com.javatest.javatest.servicios.LenguajesService;
import com.javatest.javatest.servicios.Operaciones;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class rutas {

    private final Logger logger = LoggerFactory.getLogger(rutas.class);

    private IOrderService orderService;
    private MiBean miBean;

    @Autowired
    private MiComponente miComponente;
    // se usa @Autowired para agregar Beans directamente sin pasarlos por el contructor

    @Autowired
    private LenguajesService lenguajesService;

    @Autowired
    private Operaciones operaciones;

    public rutas(IOrderService orderService, MiBean miBean){
        this.orderService = orderService;
        // OrderService es una clase, pero al etiquetarse como Service ya no se usa new
        // La idea de los servicios es usarlo donde sea y que a la hora de hacer JUnit sea mas facil
        this.miBean = miBean;
        // Los Beans son clases que pueden ser llamadas desde cualquier parte del sistema
        // No tienen que inicializarse con new al igual de que los Servicios
        // Solo se colocan en el constructor

        // -------
        // tambien existe @Component que es otro tipo de Bean

    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    String rutaHome(){
        return "home";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial){
        return "Libro con ID: " + id + " de la editorial: " + editorial;

    }

    @GetMapping("/libro2/{id}")
    String leerLibroConParams(@PathVariable int id,  @RequestParam String editorial){
        // http://localhost:8080/libro2/12?editorial=qwe
        return "Libro con ID: " + id + " de la editorial: " + editorial;

    }

    @GetMapping("/genera_error")
    public int generaError(){
        throw new NullPointerException("Estoy generando apropocito un error");
        // se desvia el NullPointerException a las RutasHander
    }

    @PostMapping("/libro")
    @ResponseStatus(HttpStatus.OK)
    String leerGuardarLibro(@RequestBody Map<String, Object> libro){
        libro.keySet().forEach(llave->{
            logger.debug("llave: {} valor: {}", llave, libro.get(llave));

        });
        return "Enviado";
    }

    @PostMapping("/libro2")
    ResponseEntity<String> leerGuardarLibro(@RequestBody Libro libro){
        try {
            if(libro.nombre==null){
                throw new Exception("el nombre no puede estar vacio");
            }
            logger.debug("libro: {} editorial: {}", libro.nombre, libro.editorial);
            return ResponseEntity.status(HttpStatus.OK).body("Enviado");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error con valores");
        }

    }

    @GetMapping("/getDataUser/V1")
    Map<String, Map<String, Object>> getDataUserV1(){
        return Map.of("User", Map.of("name","Tay","age", "20"));
    }

    @GetMapping("/getDataUser/V2")
    UserData getDataUserV2(){
        return new UserData("Tay","20");
    }

    @PostMapping("/order")
    String crearOrden(@RequestBody List<Producto> producto){
        orderService.saveOrder(producto);
        return "";
    }

    @GetMapping("/primerBean")
    String primerBean(){
        miBean.saludar();
        return "Bean Completado";
    }


    @GetMapping("/getLenguajes")
    List<Lenguajes> getLenguajes(){
        return lenguajesService.getAllLenguajes();
    }

    @PostMapping("/saveLenguajes")
    String saveLenguajes(@RequestBody Lenguajes lenguajes){
        lenguajesService.saveLenguajes(lenguajes);
        return "Guardado";
    }

    @GetMapping("/calc_factorial") // Return String
    Map<String, String> calc_factorial(@RequestParam int numero){
        int res = operaciones.factorial(numero);
        return new HashMap<>(){
                    {
                        put("mensaje", "Factorial de "+numero+" es: "+res);
                    }
                };

    }

    @GetMapping("/calc_factorial2") // Return Json
    ResponseEntity<Map<String,String>> calc_factorial2(@RequestParam int numero){
        try{
            int res = operaciones.factorial(numero);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<>(){
                        {
                            put("mensaje", "resultado: "+res);
                        }
                    });

        }
        catch (ArithmeticException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<>(){
                        {
                            put("mensaje", "Operacion Invalida");
                        }
                    });

        }

    }

}
