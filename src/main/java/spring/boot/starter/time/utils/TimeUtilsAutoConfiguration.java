package spring.boot.starter.time.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimeUtilsAutoConfiguration {

    @Bean
    public TimeUtils convertChineseTime() {
        return new TimeUtils();
    }

}
