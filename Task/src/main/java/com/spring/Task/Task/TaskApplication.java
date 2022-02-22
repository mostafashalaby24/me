package com.spring.Task.Task;

import com.spring.Task.Task.Dao.User_Repositary;
import com.spring.Task.Task.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) {

		SpringApplication.run(TaskApplication.class, args);


	}
		/*@Bean
		CommandLineRunner commandLineRunner(User_Repositary user_repositary)
		{
			return args -> {
				User user =new User(
						5L,"maire","342352352","010124124423","20/3/2020","vodafone"
				);//Lambda fun
				user_repositary.save(user);
			};
		}*/



}
