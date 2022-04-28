<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Person</title>
</head>
<body>
<form method="post" action="/people/${person.getId()}/edit">
    <input type="hidden" name="_method" value="PATCH">
    <label for="name">Enter name</label>
    <div class="form-group">
        <input type="text" class="form-control ${(textError??)?string('is-invalid', '')}"
               value="<#if message??>${message.name}</#if>" name="name" placeholder="${person.name}" id="name" />
        <#if textError??>
        <div class="invalid-feedback">
            ${textError}
        </div>
        </#if>
    <br>
    <input type="submit" value="Update!">
</form>

</body>
</html>