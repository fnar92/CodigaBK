/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author francisco.acevedo
 */
@SpringBootApplication
@ComponentScan(basePackages = {
    "mx.winit.codiga_backend.rest",
    "mx.winit.codiga_backend.service",
    "mx.winit.codiga_backend.configuration",
    "mx.winit.codiga_backend.tasks"
})
@MapperScan("mx.winit.codiga_backend.mapper")
public class Application {

    public static void main(String... args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

}
