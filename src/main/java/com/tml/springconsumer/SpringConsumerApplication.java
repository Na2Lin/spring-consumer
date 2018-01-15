package com.tml.springconsumer;

import com.alibaba.druid.pool.DruidDataSource;
import com.tml.springconsumer.service.KafkaConsumerServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.config.ContainerProperties;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages = "com.tml.springconsumer.dao")
@EnableKafka
public class SpringConsumerApplication {

	@Autowired
	KafkaConsumerServer kafkaConsumerServer;

	@Bean
	ContainerProperties containerProperties() {
		ContainerProperties topic1 = new ContainerProperties("topic1");
		topic1.setMessageListener(kafkaConsumerServer);
		return topic1;
	}

	@Bean
	@ConfigurationProperties(prefix = "datasource")
	DataSource dataSource() {
		return new DruidDataSource();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringConsumerApplication.class, args);
	}
}
