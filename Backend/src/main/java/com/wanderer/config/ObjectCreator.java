package com.wanderer.config;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectCreator {
	
	@Bean
	public Random randomObject()
	{
		return new Random();
	}

}
