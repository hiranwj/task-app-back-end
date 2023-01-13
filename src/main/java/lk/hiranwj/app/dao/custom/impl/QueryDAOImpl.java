package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.QueryDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class QueryDAOImpl implements QueryDAO {

    private final JdbcTemplate jdbcTemplate;

    public QueryDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
