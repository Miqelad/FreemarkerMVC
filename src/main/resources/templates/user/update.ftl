<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit users</title>
</head>
<body>
<form method="post" action="/${user.id}">
    <input type="hidden" name="_method" value="PATCH">
    <input type="text" name="name" placeholder="Enter the name">
    <input type="text" name="email" placeholder="Enter the email">
    <input type="submit" value="Update!">


</form>

</body>
</html>