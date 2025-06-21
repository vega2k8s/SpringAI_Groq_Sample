package com.example.speingai;

import org.springframework.ai.model.ollama.autoconfigure.OllamaChatAutoConfiguration;
import org.springframework.ai.model.openai.autoconfigure.OpenAiEmbeddingAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = {
		OllamaChatAutoConfiguration.class,
		OpenAiEmbeddingAutoConfiguration.class
})
public class GroqApplication {
	@Autowired
	Environment env;

	public static void main(String[] args) {
		SpringApplication.run(GroqApplication.class, args);
	}

	@Bean
	public String getApiKey() {
		String api_key = env.getProperty("spring.ai.openai.api-key");
		String model = env.getProperty("spring.ai.openai.chat.options.model");

		if(api_key != null){
			System.out.println("API_KEY = " + api_key.substring(0,3));
			System.out.println("Model Name = " + model);
		}
		return api_key;
	}

}
