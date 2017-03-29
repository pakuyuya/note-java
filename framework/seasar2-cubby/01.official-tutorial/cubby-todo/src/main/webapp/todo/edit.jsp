<!DOCTYPE html>
<html>
  <head>
    <title>TODO詳細 - サンプルプログラム</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/todo.css">
  </head>
  <body>
    <div id="content">
      <h2>Todoの詳細</h2>
      <c:import url="/common/errors.jsp"/>
      <div class="menu">
        [<a href="${contxtPath}/todo/">一覧に戻る</a>]
      </div>
      <t:form action="confirm" method="post" value="${action}">
        <t:input type="hidden" name="id"/>
        <table border="1">
          <tr>
            <th>内容</th>
            <td><t:input type="text" maxlength="50" name="todoText" /></td>
          </tr>
          <tr>
            <th>種別</th>
            <td>
              <t:select id="typeId" name="typeId"
                        items="${todoTypes}" labelProperty="name" valueProperty="id"/>
            </td>
          </tr>
          <tr>
            <th>期限日</th>
            <td><t:input type="text" maxlength="12" name="limitDate"/>(YYYY-MM-DD)</td>
          </tr>
          <tr>
            <th>メモ</th>
            <td><t:textarea name="memo" value="${f:out(memo)}"/></td>
          </tr>
          <tr>
            <th></th>
            <td><button type="submit">次へ</button></td>
          </tr>
        </table>
      </t:form>
    </div>
  </body>
</html>