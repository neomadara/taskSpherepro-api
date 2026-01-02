package com.zero.tasksphere;

import com.zero.tasksphere.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class TasksphereApplication {
	public static void main(String[] args) {
		SpringApplication.run(TasksphereApplication.class, args);
	}
}
