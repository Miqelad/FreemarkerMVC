<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All people</title>
</head>
<body>
<p> ${person.name} </p>
<p> ${person.id} </p>

<a href="/people/${person.id}/edit">edit</a>

<form method="post" action="/people/${person.id}">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="delete">
</form>

</body>
</html>