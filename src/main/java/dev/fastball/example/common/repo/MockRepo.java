package dev.fastball.example.common.repo;

import dev.fastball.example.common.model.BasicModel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gr@fastball.dev
 * @since 2023/1/15
 */
public abstract class MockRepo<T extends BasicModel> {
    protected final AtomicInteger maxId = new AtomicInteger(initMaxId());

    protected final Map<Integer, T> data = new HashMap<>();

    {
        for (T record : initData()) {
            data.put(record.getId(), record);
        }
    }

    protected abstract int initMaxId();

    protected abstract T[] initData();

    public void save(T entity) {
        if (entity.getId() == null) {
            entity.setId(maxId.addAndGet(1));
        }
        data.put(entity.getId(), entity);
    }

    public void delete(T entity) {
        data.remove(entity.getId());
    }

    public Collection<T> findAll() {
        return data.values();
    }


    public T findById(Integer id) {
        for (T value : data.values()) {
            if (Objects.equals(id, value.getId())) {
                return value;
            }
        }
        return null;
    }
}
