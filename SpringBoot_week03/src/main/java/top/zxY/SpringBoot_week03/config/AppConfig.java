package top.zxY.SpringBoot_week03.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String appName;
    private String Version;
    private String description;
    private Boolean published;
    private Author author;
    private List<String> features;
    @Data
    public static class Author {
        private String name;
        private String email;
        private String website;
    }
}
