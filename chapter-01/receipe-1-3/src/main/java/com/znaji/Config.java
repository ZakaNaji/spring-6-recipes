package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public PrefixGenerator prefixGenerator() {
        return new DatePrefixGenerator("yyyyMMdd");
    }

    @Bean
    public Sequence sequenceGenerator(PrefixGenerator prefixGenerator) {
        Sequence sequence = new Sequence("A", 100);
        sequence.setPrefixGenerator(prefixGenerator);
        return sequence;
    }
}
