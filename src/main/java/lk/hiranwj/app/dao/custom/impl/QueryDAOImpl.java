package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.QueryDAO;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
public class QueryDAOImpl implements QueryDAO {

    private final Connection connection;

    public QueryDAOImpl(Connection connection) {
        this.connection = connection;
    }
}
