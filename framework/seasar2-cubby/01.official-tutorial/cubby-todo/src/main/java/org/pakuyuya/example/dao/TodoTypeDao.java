package org.pakuyuya.example.dao;

import java.util.ArrayList;
import java.util.List;
import org.pakuyuya.example.entity.TodoType;

import org.pakuyuya.example.util.enums.TodoTypes;

public class TodoTypeDao {
    public List<TodoType> selectAll() {
        ArrayList<TodoType> list = new ArrayList<>();
        for (TodoTypes e : TodoTypes.enableValues()) {
            list.add(toDto(e));
        }
        return list;
    }
    
    public TodoType selectById(int id) {
        return toDto(TodoTypes.of(id));
    }
    
    private TodoType toDto(TodoTypes type) {
        TodoType dto = new TodoType();
        dto.setId(type.id);
        dto.setName(type.name);
        return dto;
    }
}
