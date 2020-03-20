package com.isaac.datahelper.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
public class SqlInfo {
    private String templateName;
    private Map<String, Object> templateData;
}
