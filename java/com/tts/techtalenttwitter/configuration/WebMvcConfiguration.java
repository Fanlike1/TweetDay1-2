package com.tts.techtalenttwitter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // class is class that configuration information
			  // how to creates object that are autowired.


public class WebMvcConfiguration implements WebMvcConfigurer{
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = 
				new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
