package com.ykmura.springmybatisencrypt.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ykmura.springmybatisencrypt.cipher.CaesarCipher;
import com.ykmura.springmybatisencrypt.typehandler.CaesarCipherStringTypeHandler;

import lombok.RequiredArgsConstructor;

@Configuration
@MapperScan("com.ykmura.springmybatisencrypt.repository")
@RequiredArgsConstructor
public class MyBatisConfig {

    private final CaesarCipher caesarCipher;

    @Bean
    ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return configuration -> {
            configuration.getTypeHandlerRegistry().register(new CaesarCipherStringTypeHandler(caesarCipher));
        };
    }
}
