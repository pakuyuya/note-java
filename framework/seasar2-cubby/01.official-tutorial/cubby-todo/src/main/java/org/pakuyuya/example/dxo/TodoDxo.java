package org.pakuyuya.example.dxo;

import org.pakuyuya.example.action.TodoAction;
import org.pakuyuya.example.entity.Todo;

public interface TodoDxo {
    String DATE_PATTERN = "yyyy-MM-dd";
    
    public void convert(Todo src, TodoAction dest);
    public Todo convert(TodoAction src);
}
