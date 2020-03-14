<!DOCTYPE html>
<html>
  <head>
    <title>TODO詳細 - サンプルプログラム</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/todo.css">
    <script>
      function doBack() {
          var form = document.getElementById('form');

            form.style.display = 'none';
            form.action = '/todo/conrirm_back';
            form.method = 'post';

            document.body.appendChild(form);

            form.submit();
      }
    </script>
  </head>
  <body>
    <t:form action="${contextPath}/todo/save" method="post" value="${action}" id="form">
      <t:input type="hidden" name="id"/>
      <t:input type="hidden" name="todoText"/>
      <t:input type="hidden" name="typeId"/>
      <t:input type="hidden" name="limitDate" value="${limitDate}"/>
      <t:input type="hidden" name="memo"/>
      <div id="content">
        <h2>Todoの詳細</h2>
        <div class="menu">
          [<a href="#" onclick="doBack()">一戻る</a>]
        </div>
        <table border="1">
          <tr>
            <th>内容</th>
            <td>${f:out(todoText)}</td>
          </tr>
          <tr>
            <th>種別</th>
            <td>${f:out(todoType.name)}</td>
          </tr>
          <tr>
            <th>期限日</th>
            <td>${f:out(limitDate)}</td>
          </tr>
          <tr>
            <th>メモ</th>
            <td>${f:out(memo)}</td>
          </tr>
          <tr>
            <th></th>
            <td>
              <button type="submit">登録</button>
            </td>
          </tr>
        </table>
      </div>
    </t:form>
    <c:import url="/fotter.jsp"/>
  </body>
</html>