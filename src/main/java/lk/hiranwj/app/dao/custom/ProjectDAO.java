package lk.hiranwj.app.dao.custom;

import lk.hiranwj.app.dao.CrudDAO;
import lk.hiranwj.app.entity.Project;

import java.util.List;

public interface ProjectDAO extends CrudDAO<Project, Integer> {

    List<Project> findAllProjectsByUsername(String username);
}
