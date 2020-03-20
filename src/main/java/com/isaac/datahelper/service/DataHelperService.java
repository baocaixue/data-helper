package com.isaac.datahelper.service;

import com.isaac.datahelper.domain.SqlInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class DataHelperService {
    @Autowired
    @Qualifier("jdbcTemplate1")
    private JdbcTemplate jdbcTemplate1;
    @Autowired
    private TemplateAndDataService templateAndDataService;

    public List<Map<String, Object>> findDataBySql(SqlInfo sqlInfo) throws Exception{
        var sql = templateAndDataService.compileTemplate(sqlInfo.getTemplateName(), sqlInfo.getTemplateData());
        log.info(sql);
        return jdbcTemplate1.query(sql, (rs, rowNum) -> {
            var row = new HashMap<String, Object>(rowNum);
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                row.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
            }
            return row;
        });
    }
}
