<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All users</title>
</head>
<body>
<#list users as user>
    <div>
        ${user.name}
    </div>
    <form method="post" action="/delete/${user.id}">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="delete">
    </form>
    <form>
        <div>
        <a href="/update/${user.id}">edit</a>
        </div>
    </form>
    <form method="get" action="/param/${user.id}">
        <input type="text" name="id" placeholder="${user.id}" >
        <input type="submit" value="paramInfo">
    </form>
<#--    добавление картинки-->
    <form method="post" action="/file/hello" enctype="multipart/form-data">
            <input type="file" name="file">
            <input type="submit" value="saveFile">
        </form>
<#--    отображение картинки-->

        <#list filerload as flp>
        <#if flp??>
            <div>
            <img src="/file/img/${flp.file}">

            </div>
        </#if>
        <#else>
            <h4>Error upload file</h4>

        </#list>


</#list>
<a href="/new"></a>




</body>
</html>