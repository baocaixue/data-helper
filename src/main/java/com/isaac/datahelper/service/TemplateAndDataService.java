package com.isaac.datahelper.service;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class TemplateAndDataService {
    @Autowired
    private Configuration fmtConfiguration;
    @Value("${sql-info.templates-folder}")
    private String templateFolder;

    public String compileTemplate(String templateName, Map<String, Object> sqlData) throws IOException, TemplateException {
        fmtConfiguration.setDirectoryForTemplateLoading(new File(templateFolder));
        var template = fmtConfiguration.getTemplate(templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, sqlData);
    }
}
