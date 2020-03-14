<!DOCTYPE html>
<html>
  <head>
    <title>TODO詳細 - サンプルプログラム</title>
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
      <h2>Todoの詳細</h2>
      <div class="menu">
        [<a href="${contxtPath}/todo/">一覧に戻る</a>]
        [<a href="${contxtPath}/todo/edit?id=${id}">編集</a>]
        [<a href="#" onclick="doDelete('${f:out(todoText)}', ${f:out(id)})">削除</a>]
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
      </table>
    </div>
  </body>
</html>