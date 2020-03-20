package com.isaac.datahelper.controller;

import com.isaac.datahelper.domain.SqlInfo;
import com.isaac.datahelper.service.DataHelperService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "v1")
@AllArgsConstructor
public class DataHelperController {
    private DataHelperService dataHelperService;

    @PostMapping("test")
    public List<Map<String, Object>> test(@RequestBody SqlInfo sqlInfo) throws Exception{
        return dataHelperService.findDataBySql(sqlInfo);
    }
}
