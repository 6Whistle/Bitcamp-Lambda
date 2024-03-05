package common;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract String save(T t);
    public abstract String delete(T t);
    public abstract String deleteAll();
    public abstract List<T> findAll();
    public abstract Optional<T> findById(Long id);
    public abstract Long count();
    public abstract Optional<T> getOne(String id);
    public abstract Boolean existsById(Long id);
}
