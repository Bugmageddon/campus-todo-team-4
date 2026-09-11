package edu.hbuas.campustodo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("edu.hbuas.campustodo.mapper")
public class CampusTodoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CampusTodoApplication.class, args);
    }

}
