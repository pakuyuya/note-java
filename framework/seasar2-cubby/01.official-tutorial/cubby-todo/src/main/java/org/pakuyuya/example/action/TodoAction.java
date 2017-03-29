package org.pakuyuya.example.action;

import java.util.List;

import org.pakuyuya.example.dao.TodoDao;
import org.pakuyuya.example.dao.TodoTypeDao;
import org.pakuyuya.example.entity.TodoType;
import org.pakuyuya.example.dxo.TodoDxo;
import org.pakuyuya.example.entity.Todo;
import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.Redirect;
import org.seasar.cubby.action.RequestParameter;
import org.seasar.cubby.action.Validation;
import org.seasar.cubby.validator.DefaultValidationRules;
import org.seasar.cubby.validator.ValidationRules;
import org.seasar.cubby.validator.validators.DateFormatValidator;
import org.seasar.cubby.validator.validators.RequiredValidator;

public class TodoAction extends Action {
    public ValidationRules validation = new DefaultValidationRules() {
        @Override
        public void initialize() {
            add("todoText", new RequiredValidator());
            add("limitDate", new DateFormatValidator());
        }
    };
    
    public TodoDao todoDao;
    public TodoDxo todoDxo;
    public TodoTypeDao todoTypeDao;

    public @RequestParameter Integer id;
    public @RequestParameter String todoText;
    public @RequestParameter String memo;
    public @RequestParameter String limitDate;
    public @RequestParameter Integer typeId;
    public TodoType todoType;

    public List<TodoType>getTodoTypes() {
        return todoTypeDao.selectAll();
    }

    @Path("{id,[0-9]+}")
    public ActionResult show() {
        Todo todo = todoDao.selectById(id);
        todoDxo.convert(todo,  this);
        return new Forward("show.jsp");
    }

    public ActionResult create() {
        return new Forward("edit.jsp");
    }

    public ActionResult edit() {
        Todo todo = todoDao.selectById(id);
        todoDxo.convert(todo, this);
        return new Forward("edit.jsp");
    }

    @Validation(rules = "validation", errorPage = "edit.jsp")
    public ActionResult confirm() {
        TodoType type = todoTypeDao.selectById(typeId);
        this.todoType = type;
        return new Forward("confirm.jsp");
    }

    public ActionResult conrirm_back() {
        return new Forward("edit.jsp");
    }

    @Validation(rules = "validation", errorPage = "confirm.jsp")
    public ActionResult save() {
        if (this.id == null) {
            Todo todo = todoDxo.convert(this);
            todoDao.insert(todo);
            flash.put("notice",  todo.getTodoText() + "を追加しました。");
        } else {
            Todo todo = todoDxo.convert(this);
            todoDao.update(todo);
            flash.put("notice",  todo.getTodoText() + "を追加しました。");
        }
        return new Redirect("/todo/");
    }
    
    public ActionResult delete() {
        // do nothing
        return new Redirect("/todo/");
    }
}
