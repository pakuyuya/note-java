<!DOCTYPE html>
<html>
  <head>
    <title>ログイン - サンプルプログラム</title>
    <meta charset="UTF-8">
  </head>
  <body>
    <c:import url="/common/errors.jsp"/>
    <t:form action="${contextPath}/todo/login/process" method="post" value="${action}">
      <fieldset>
        <legend>ログイン</legend>
        <table>
          <tr>
            <th>ログインID</th>
            <td><input type="text" name="userId" maxlength="32" /></td>
          </tr>
          <tr>
            <th>パスワード</th>
            <td><input type="text" name="userId" maxlength="32" /></td>
          </tr>
          <tr>
            <th></th>
            <td><button type="submit">ログイン</button></td>
          </tr>
        </table>
      </fieldset>
    </t:form>
  </body>
</html>