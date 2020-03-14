package org.pakuyuya.example.entity;

import java.util.Date;


public class Todo {
    private Integer id;
    private String todoText;
    private String memo;
    private Date limitDate;
    private TodoType todoType;
    private Integer typeId;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTodoText() {
        return todoText;
    }
    public void setTodoText(String todoText) {
        this.todoText = todoText;
    }
    public TodoType getTodoType() {
        return todoType;
    }
    public void setTodoType(TodoType todoType) {
        this.todoType = todoType;
    }
    public Date getLimitDate() {
        return limitDate;
    }
    public void setLimitDate(Date limitDate) {
        this.limitDate = limitDate;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Integer getTypeId() {
        return typeId;
    }
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
