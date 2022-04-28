<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Param testing</title>
</head>
<body>
<#list param as p >
    <div>
        <h4>${p.getName()}</h4>
    </div>
</#list>
<form>
    <div>
        <a href="/">show me main page</a>
    </div>
</form>

</body>
</html>