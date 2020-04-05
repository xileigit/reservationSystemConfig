package com.leilei.client.feign;

import com.leilei.common.FormEncoder;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignSimpleEncoderConfig {
    @Bean
    public Encoder encoder(){
        return new FormEncoder();
    }
}
