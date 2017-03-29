<!DOCTYPE html>
<html>
  <head>
    <title>TODO - サンプルプログラム</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/todo.css">
    <script>
      function doDelete(text, id) {
          var msg = text + "を削除します。よろしいですか？";
          if (confirm(msg)) {
              var form = document.createElement('form');

              form.style.display = 'none';
              form.action = '/todo/delete?id=' + id;
              form.method = 'post';
              
              document.body.appendChild(form);

              form.submit();
          }
      }
      </script>
  </head>
  <body>
    <div id="content">
      <c:import url="/common/notice.jsp"/>
      <h2>Todoの一覧</h2>
      <c:import url="/common/errors.jsp"/>
      <div class="menu">
        [<a href="${contextPath}/todo/create">新規作成</a>]
      </div>

      <t:form action="${contextPath}/todo/" method="post" value="${todoConditionDto}">
        <fieldset>
          <table>
            <tr>
              <th>キーワード</th>
              <td><input type="text" name="keyword" maxlength="10" /></td>
            </tr>
            <tr>
              <th>種別</th>
              <td>
                <t:select id="typeId" name="typeId"
                          items="${action.todoTypes}" labelProperty="name" valueProperty="id"/>
              </td>
            </tr>
            <tr>
              <th>期限日</th>
              <td>
                <t:input type="text" id="limitDate" name="limitDatae" size="10" maxsize="10"/>
              </td>
            </tr>
            <tr>
              <th></th>
              <td>
                <button type="submit">検索</button>
              </td>
            </tr>
          </table>
        </fieldset>
      </t:form>
      <table>
        <tr>
          <th>内容</th>
          <th>種別</th>
          <th>期限日</th>
          <th>アクション</th>
        </tr>
        <c:forEach var="todo" items="${action.todoList}" varStatus="status">
          <tr class="${f:odd(status.index, 'odd,even')}">
            <td><a href="${contextPath}/todo/${f:out(todo.id)}">${f:out(todo.todoText)}</a></td>
            <td>${f:out(todo.todoType.name)}</td>
            <td>${f:dateFormat(todo.limitDate, 'yyyy-MM-dd')}</td>
            <td>[<a href="javascript:doDelete('${f:out(todo.todoText)}', ${f:out(todo.id)});">削除</a>]</td>
          </tr>
        </c:forEach>
      </table>
    </div>
  </body>
</html>