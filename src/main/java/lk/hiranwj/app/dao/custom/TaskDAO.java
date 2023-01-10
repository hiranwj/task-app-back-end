package lk.hiranwj.app.dao.custom;

import lk.hiranwj.app.dao.CrudDAO;
import lk.hiranwj.app.entity.Task;

import java.util.List;

public interface TaskDAO extends CrudDAO<Task, Integer> {

    List<Task> findAllTasksByProjectId(Integer projectId);
}
