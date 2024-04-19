<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="/static/css/info.css" type="text/css" rel="stylesheet">
    <title>Document</title>
</head>
<body>

<div class="mainDiv">
    <div class="Div">
        <form action="/up" method="POST">
            <div class="mb-3">
                <input type="hidden" name="id" value="${noteInfo.getId()}">
                <#--<input type="hidden" name="createAt" value="${noteInfo.getCreateAt()}">

                <div style="display: flex; font-size: 10px">
                    <p>Время создания: ${noteInfo.getCreateAt()}</p>
                    <#if noteInfo.getUpdateAt()?has_content>
                        <p>Время изминения: ${noteInfo.getCreateAt()}</p>
                    </#if>
                </div>-->

                <label for="exampleFormControlInput1" class="form-label">Название:</label>
                <input name="title" type="text" class="form-control" id="exampleFormControlInput1" value="${noteInfo.getTitle()}">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Текст</label>
                <#if noteInfo.getDescription()?has_content><textarea name="description" class="form-control ariaclass" id="exampleFormControlTextarea1" placeholder="Введите текст..." rows="3">${noteInfo.getDescription()}</textarea>
                <#else> <textarea name="description" class="form-control ariaclass" id="exampleFormControlTextarea1" placeholder="Введите текст..." rows="3"></textarea>
                </#if>

            </div>

            <input type="submit" value="Cохранить">
        </form>
        <form action="/delete/${noteInfo.getId()}" method="POST">
            <input type="submit" value="Удалить">
        </form>

        <div class="home">
            <form action="/home">
                <input type="submit" value="На главную">
            </form>
        </div>

    </div>
</div>
</body>
</html>