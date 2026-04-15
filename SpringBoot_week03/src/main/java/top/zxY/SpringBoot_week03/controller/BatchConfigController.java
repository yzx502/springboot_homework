package top.zxY.SpringBoot_week03.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zxY.SpringBoot_week03.Common.Result;
import top.zxY.SpringBoot_week03.config.AppConfig;
import top.zxY.SpringBoot_week03.dto.AppConfigDTO;
@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
public class BatchConfigController {
    private final AppConfig appConfig;
    @RequestMapping("/batch")
    public Result<AppConfigDTO> getBatchConfigInfo() {
        return Result.success(AppConfigDTO.from(appConfig));
    }
}
