package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.ProjectDAO;
import lk.hiranwj.app.entity.Project;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class ProjectDAOImpl implements ProjectDAO {

    private Connection connection;

    public ProjectDAOImpl(Connection connection) {

    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void deleteById() {

    }

    @Override
    public Optional<Project> findById(Integer pk) {
        return Optional.empty();
    }

    @Override
    public List<Project> findAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existById(Integer pk) {
        return false;
    }
}
