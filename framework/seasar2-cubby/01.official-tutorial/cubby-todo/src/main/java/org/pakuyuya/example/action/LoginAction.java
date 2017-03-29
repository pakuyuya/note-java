package org.pakuyuya.example.action;

import java.util.Map;

import org.pakuyuya.example.entity.User;
import org.seasar.cubby.action.Action;
import org.seasar.cubby.action.ActionResult;
import org.seasar.cubby.action.Forward;
import org.seasar.cubby.action.Path;
import org.seasar.cubby.action.Redirect;
import org.seasar.cubby.action.RequestParameter;
import org.seasar.cubby.action.Validation;
import org.seasar.cubby.validator.DefaultValidationRules;
import org.seasar.cubby.validator.ValidationRules;
import org.seasar.cubby.validator.validators.RequiredValidator;

@Path("todo/login")
public class LoginAction extends Action {

    public Map<String, Object> sessionScope;
    public @RequestParameter String userId;
    public @RequestParameter String password;

    public ValidationRules loginValidation = new DefaultValidationRules("login.") {
        @Override
        public void initialize() {
            add("userId", new RequiredValidator());
            add("password", new RequiredValidator());
        }
    };

    public ActionResult index() {
        return new Forward("/todo/login.jsp");
    }

    @Validation(rules="loginValidation", errorPage="/todo/login.jsp")
    public ActionResult prosess() {
        User user = login(userId, password);

        if (user != null) {
            sessionScope.put("user", user);
            return new Redirect("/example/");
        } else {
            errors.add("ユーザーIDかパスワードが違います。");
            return new Forward("/example/login.jsp");
        }
    }

    private User login(String userId, String password) {
        if ("test".equals(userId) && "test".equals("password")) {
            User user = new User();
            user.setId(1);
            user.setName("Cubby");

            return user;
        }
        return null;
    }
}
