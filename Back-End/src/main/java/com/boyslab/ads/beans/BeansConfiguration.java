package com.boyslab.ads.beans;

import com.boyslab.ads.service.mernis.HSCKPSPublicSoap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {

    @Bean
    public HSCKPSPublicSoap hsckpsPublicSoap(){
        return  new HSCKPSPublicSoap();
    }
}
