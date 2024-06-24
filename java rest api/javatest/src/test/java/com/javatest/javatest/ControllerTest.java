package com.javatest.javatest;

import com.javatest.javatest.repository.LenguajesRepository;
import com.javatest.javatest.servicios.IOperaciones;
import com.javatest.javatest.servicios.Operaciones;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(
        exclude = {
                DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                HibernateJpaAutoConfiguration.class
        }
)
public class ControllerTest {

        @Autowired
        private WebTestClient webTestClient;

        @MockBean
        private Operaciones operacionesMock;

        @MockBean
        private LenguajesRepository lenguajesRepository;

        @BeforeEach
        public void setup(){
                Mockito.when(operacionesMock.factorial(ArgumentMatchers.anyInt())).thenReturn(0);
        }

        @Test
        public void factorialControllerTest(){
                webTestClient.get()
                        .uri("/calc_factorial2?numero=-5")
                        .exchange()
                        .expectStatus().isOk()
                        .expectBody()
                        .jsonPath("$.mensaje")
                        .isEqualTo("resultado: 0");
        }

        @Test
        public void factorialControllerFailTest(){
                Mockito.when(operacionesMock.factorial(ArgumentMatchers.anyInt())).thenThrow(ArithmeticException.class);
                webTestClient.get()
                        .uri("/calc_factorial2?numero=-5")
                        .exchange()
                        .expectStatus().is4xxClientError()
                        .expectBody()
                        .jsonPath("$.mensaje")
                        .isEqualTo("Operacion Invalida");
        }

        /*
        @Test
        public void postTest(){
                webTestClient.post()
                        .uri("/linkpost")
                        .exchange()
                        .expectStatus().isOk()
                        .expectBody()
                        .jsonPath("$")
                        .isEqualTo("Operacion Exitosa");
        }
        */

}
