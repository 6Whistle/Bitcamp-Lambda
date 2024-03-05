package common;

import enums.Messenger;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save(T t);
    public abstract Messenger delete(T t);
    public abstract Messenger deleteAll();
    public abstract List<T> findAll();
    public abstract Optional<T> findById(Long id);
    public abstract Long count();
    public abstract Optional<T> getOne(String id);
    public abstract Boolean existsById(Long id);
}
