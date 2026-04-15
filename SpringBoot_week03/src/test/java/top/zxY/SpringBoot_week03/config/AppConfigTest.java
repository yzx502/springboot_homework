package top.zxY.SpringBoot_week03.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@Slf4j
@SpringBootTest
class AppConfigTest{
    @Resource
    private AppConfig  appConfig;

    @Test
    public void getAppConfigInfo(){
        log.info("名称:{}",appConfig.getAppName());
        log.info("版本:{}",appConfig.getVersion());
        log.info("描述:{}",appConfig.getDescription());
        log.info("是否发布:{}",appConfig.getPublished());
        log.info("作者:{}",appConfig.getAuthor());
        log.info("特性:{}",appConfig.getFeatures());
    }
}

