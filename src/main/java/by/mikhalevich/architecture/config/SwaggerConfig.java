package by.mikhalevich.architecture.config;

//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.List;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//public class SwaggerConfig {
//
//    public static final String I_COURSE_API = "iCourse API";
//    public static final String VERSION = "2.0.0";
//    public static final String AIRCRAFT_CONTROLLER = "Aircraft controller";
//
//
//    @Bean
//    public Docket getBean(){
//        return new Docket((DocumentationType.SWAGGER_2)).select().paths(regex("/api.*")).build().apiInfo(customOpenApi());
//    }
//
//    @Bean
//    public ApiInfo customOpenApi() {
//        return new ApiInfoBuilder().title(I_COURSE_API).description(AIRCRAFT_CONTROLLER).license(VERSION).build();
//    }
//}
