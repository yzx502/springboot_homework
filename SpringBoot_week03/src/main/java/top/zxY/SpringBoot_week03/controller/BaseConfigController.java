package top.zxY.SpringBoot_week03.controller;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zxY.SpringBoot_week03.Common.Result;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseConfigController {
   @Value("企业后台管理系统")
    private String appName;

    @Value("1.0.1")
    private String version;

    @Value("基于 SpringBot 3.5.11构建")
    private String description;

    @Value("false")
    private Boolean published;

    @Value("8081")
    private Integer port;

    @Value("/api")
    private String contextPath;

    @Value("SpringBoot_week03")
    private String applicationName;

    @GetMapping("/base")
    public Result<Map<String, Object>> getBaseConfigInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("port", port);
        map.put("contextPath", contextPath);
        map.put("applicationName", applicationName);
        map.put("appName", appName);
        map.put("version", version);
        map.put("description", description);
        map.put("published", published);
        return Result.success(map);
    }

}

