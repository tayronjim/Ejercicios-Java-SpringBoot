package com.javatest.javatest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavatestApplication {

	private static final Logger logger = LoggerFactory.getLogger(JavatestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JavatestApplication.class, args);
		logger.debug("Mensaje Debug");
		logger.info("Mensaje Info");
		logger.error("Mensaje Error");
		logger.warn("Mensaje Warning");

		// Se instalo la implementacion y se habilito en la configuracion
		// para poder usar
		// ******          http://127.0.0.1:8080/actuator  ****
		//  y extraer diferentes valores de metricas de como esta en este momento el sistema

	}

}
