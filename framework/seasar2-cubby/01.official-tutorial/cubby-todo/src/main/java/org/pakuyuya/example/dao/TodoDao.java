package org.pakuyuya.example.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.pakuyuya.example.dto.TodoConditionDto;
import org.pakuyuya.example.entity.TodoType;
import org.pakuyuya.example.entity.Todo;
import org.pakuyuya.example.util.enums.TodoTypes;

public class TodoDao {
    public List<Todo> selectByCondition(TodoConditionDto condition) {
        // mock
        List<Todo> todos = new ArrayList<>();

        todos.add(todo(1, "todo1", TodoTypes.TASK, new Date(), "memo1"));
        todos.add(todo(2, "todo2", TodoTypes.NARROW, new Date(), "memo2"));

        return todos;
    }

    public Todo selectById(int id) {
        return todo(1, "todo1", TodoTypes.TASK, new Date(), "memo1");
    }

    public void insert(Todo todo) {
        // do nothing.
    }

    public void update(Todo todo) {
        // do nothing.
    }

    private Todo todo(int id, String todoText, TodoTypes todoType, Date limitDate, String memo) {
        Todo todo = new Todo();
        
        TodoType type = new TodoType();
        type.setId(todoType.id);
        type.setName(todoType.name);

        todo.setId(id);
        todo.setTodoText(todoText);
        todo.setTodoType(type);
        todo.setLimitDate(limitDate);
        todo.setTypeId(type.getId());
        todo.setMemo(memo);

        return todo;
    }
}
