package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.QueryDAO;
import lk.hiranwj.app.dao.util.ConnectionUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
@Scope("request")
public class QueryDAOImpl implements QueryDAO {

    private final Connection connection;

    public QueryDAOImpl() {
        this.connection = ConnectionUtil.getConnection();
    }
}
