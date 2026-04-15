package top.zxY.SpringBoot_week03.dto;

import lombok.Data;
import top.zxY.SpringBoot_week03.config.AppConfig;

import java.util.List;

@Data
public class AppConfigDTO{
    private String appName;
    private AppConfig version;
    private String description;
    private Boolean published;
    private AuthorDTO author;
    private List<String> features;


    public static AppConfigDTO from(AppConfig appConfig) {
        AppConfigDTO dto = new AppConfigDTO();
        dto.setAppName(appConfig.getAppName());
        dto.setVersion(appConfig.getVersion());
        dto.setDescription(appConfig.getDescription());
        dto.setPublished(appConfig.getPublished());
        dto.setAuthor(AuthorDTO.from(appConfig.getAuthor()));
        dto.setFeatures(appConfig.getFeatures());
        return dto;
    }

    private void setVersion(String version) {
    }

    @Data
    public static class AuthorDTO {
        private String name;
        private String website;
        private String email;

        public static AuthorDTO from(AppConfig.Author author) {
            AuthorDTO dto = new AuthorDTO();
            dto.setName(author.getName());
            dto.setWebsite(author.getWebsite());
            dto.setEmail(author.getEmail());
            return dto;
        }

    }
}
