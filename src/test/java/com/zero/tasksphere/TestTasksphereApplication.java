package com.zero.tasksphere;

import org.springframework.boot.SpringApplication;

public class TestTasksphereApplication {

	public static void main(String[] args) {
		SpringApplication.from(TasksphereApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
