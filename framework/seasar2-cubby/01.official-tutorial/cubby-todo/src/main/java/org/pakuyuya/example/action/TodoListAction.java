package org.pakuyuya.example.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.pakuyuya.example.dao.TodoDao;
import org.pakuyuya.example.dao.TodoTypeDao;
import org.pakuyuya.example.dto.TodoConditionDto;
import org.pakuyuya.example.entity.TodoType;
import org.pakuyuya.example.entity.Todo;
import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Form;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.Validation;
import org.seasar.cubby.controller.FormatPattern;
import org.seasar.cubby.validator.DefaultValidationRules;
import org.seasar.cubby.validator.ValidationRules;
import org.seasar.cubby.validator.validators.DateFormatValidator;

@Path("todo")
public class TodoListAction extends Action {
    public ValidationRules validation = new DefaultValidationRules() {
        @Override
        public void initialize() {
            add("limitDate", new DateFormatValidator());
        }
    };

    public FormatPattern formatPattern;
    public TodoDao todoDao;
    public TodoTypeDao todoTypeDao;

    public TodoConditionDto todoConditionDto;
    public List<Todo> todoList;


    @Form("todoConditionDto")
    @Validation(rules="validation", errorPage="list.jsp")
    public ActionResult index() {
        this.todoList = todoDao.selectByCondition(todoConditionDto);
        return new Forward("list.jsp");
    }

    public List<TodoType> getTodoTypes() {
        List<TodoType> todoTypes = todoTypeDao.selectAll();
        return todoTypes;
    }

    public String getQueryStrng() {
        StringBuilder sb = new StringBuilder();

        if (todoConditionDto.hasKeyword()) {
            sb.append("キーワード:")
                .append(todoConditionDto.getKeyword())
                .append(" ");
        }

        if (todoConditionDto.hasTypeId()) {
            sb.append("種別:")
                .append(todoTypeDao.selectById(todoConditionDto.getTypeId()).getName())
                .append(" ");
        }

        if (todoConditionDto.hasLimitDate()) {
            DateFormat dateFormat = new SimpleDateFormat(formatPattern.getDatePattern());
            sb.append("期限日<=")
                .append(dateFormat.format(todoConditionDto.getLimitDate()))
                .append(" ");
        }

        return sb.toString();
    }
}
