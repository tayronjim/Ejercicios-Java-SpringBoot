import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customers", r -> r
                        .path("/api/customers/**")
                        .uri("http://34.125.111.144:9001")
                        .filters(f -> f.rewritePath("/api/customers/(?<segment>.*)", "/$\{segment}")))
                .route("employees", r -> r
                        .path("/api/employees/**")
                        .uri("http://34.125.111.144:9000")
                        .filters(f -> f.rewritePath("/api/employees/(?<segment>.*)", "/$\{segment}")))
                .route("suppliers", r -> r
                        .path("/api/suppliers/**")
                        .uri("http://34.125.111.144:9002")
                        .filters(f -> f.rewritePath("/api/suppliers/(?<segment>.*)", "/$\{segment}")))
                .route("webapp", r -> r
                        .path("/**")  // Matches all paths
                        .uri("http://34.125.111.144:9003")
                        .filters(f -> f.rewritePath("/(?<segment>.*)", "/$\{segment}")))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}
