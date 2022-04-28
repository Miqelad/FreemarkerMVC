<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All people</title>
</head>
<body>
<div>
    <#list people as p>
        <a href="/people/${p.id}">${p.name}</a>
    </#list>
</div>

</body>
</html>