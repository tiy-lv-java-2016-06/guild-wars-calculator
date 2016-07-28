package com.theironyard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GuildWars2CalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuildWars2CalcApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
