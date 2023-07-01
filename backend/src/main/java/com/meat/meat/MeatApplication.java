package com.meat.meat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableJpaRepositories
public class MeatApplication {

    private static final Logger logger = LoggerFactory.getLogger(MeatApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(MeatApplication.class);
        Environment env = app.run(args).getEnvironment();
        definirLog(env);
    }

    private static void definirLog(Environment env) throws UnknownHostException {
        logger.info("""
                        \t
                        ----------------------------------------------------------
                        \tAplicação '{}' rodando com sucesso! Access URLs:
                        \tLocal: \t\t{}://localhost:{}
                        \tExterno: \t{}://{}:{}
                        \tPerfil(s): \t{}
                        ----------------------------------------------------------
                        """,
                env.getProperty("spring.application.name"), "http",
                env.getProperty("server.port"), "http",
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getActiveProfiles());
    }

}
