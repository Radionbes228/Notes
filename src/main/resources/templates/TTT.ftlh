<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/static/css/css.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>



<div class="item">
    <#list notes as note>
        <a href="/info/${note.getId()}">
            <div class="card border-info mb-3" style="width: 18rem; margin: 25px 25px;">
                <div class="card-header">${note.getTitle()}</div>
                <div class="card-body">
                    <h5 class="card-title">Заметки:</h5>
                    <#if note.getDescription()?has_content>
                        <p class="card-text">${note.getDescription()}</p>
                        <#else><p class="card-text"></p>
                    </#if>
                </div>
            </div>
        </a>
    </#list>
</div>

<#--Создание заметки-->
<form method="POST" action="/home">
    <div class="create">
        <#if exception?has_content>
            <h5 style="color: red; margin: 0 auto">${exception}</h5>
        </#if>
        Имя<br><input type="text" name="title"><br>
        Текст<br><textarea name="description"></textarea><br>

        <input type="submit" value="Создать">
    </div>
</form>




</body>
</html>