package com.example.customer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

@Configuration
public class RedisConfiguration {

	  @Bean
	  public JedisConnectionFactory redisConnectionFactory() {
	    return new JedisConnectionFactory();
	  }

}