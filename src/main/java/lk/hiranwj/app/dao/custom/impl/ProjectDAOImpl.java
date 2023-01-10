package lk.hiranwj.app.dao.custom.impl;

import lk.hiranwj.app.dao.custom.ProjectDAO;
import lk.hiranwj.app.entity.Project;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProjectDAOImpl implements ProjectDAO {

    private Connection connection;

    public ProjectDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Project save(Project project) {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO Project (name, username) VALUES (?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            stm.setString(1, project.getName());
            stm.setString(2, project.getUsername());
            stm.executeUpdate();
            ResultSet generatedKeys = stm.getGeneratedKeys();
            generatedKeys.next();
            project.setId(generatedKeys.getInt(1));
            return project;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Project project) {

    }

    @Override
    public void deleteById(Integer pk) {

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
    public boolean existsById(Integer pk) {
        return false;
    }

}
