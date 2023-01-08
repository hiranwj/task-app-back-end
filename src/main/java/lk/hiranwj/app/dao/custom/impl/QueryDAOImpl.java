package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.QueryDAO;

import java.sql.Connection;

public class QueryDAOImpl implements QueryDAO {

    private final Connection connection;

    public QueryDAOImpl(Connection connection) {
        this.connection = connection;
    }
}
