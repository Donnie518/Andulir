package org.andulir.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConfigurationProperties(prefix = "andulir.thread")
@Data
@NoArgsConstructor
public class ThreadPoolProperty {

    @Value("${andulir.thread.core-size}")
    private Integer coreSize;

    @Value("${andulir.thread.max-size}")
    private Integer maxSize;

    @Value("${andulir.thread.keep-alive-time}")
    private Integer keepAliveTime;

//    @PostConstruct
//    public void init() {
//        System.out.println("ThreadPoolProperty: coreSize=" + coreSize + ", maxSize=" + maxSize + ", keepAliveTime=" + keepAliveTime);
//    }
}
