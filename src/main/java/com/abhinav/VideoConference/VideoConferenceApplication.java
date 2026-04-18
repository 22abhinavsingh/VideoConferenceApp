package com.abhinav.VideoConference;

import com.abhinav.VideoConference.Service.UserService;
import com.abhinav.VideoConference.User.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideoConferenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoConferenceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			UserService service
	){
		return args->{

			service.registerUser(User.builder()
							.username("Abhinav")
							.password("aaa")
							.email("abhi@gmail.com")
					.build());

			service.registerUser(User.builder()
							.username("Nidhi")
							.password("aaa")
							.email("nidhi@gmail.com")
					.build());

			service.registerUser(User.builder()
							.username("Aniket")
							.password("aaa")
							.email("aniket@gmail.com")
					.build());
		};
	}
}
