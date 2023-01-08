package lk.hiranwj.app.dao;

import lk.hiranwj.app.entity.SuperEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDAO <T extends SuperEntity, ID extends Serializable> extends SuperDAO {

    T save(T t);

    public void update();

    public void deleteById();

    public Optional<T> findById(ID pk);

    public List<T> findAll();

    public long count();

    boolean existById(ID pk);
}
