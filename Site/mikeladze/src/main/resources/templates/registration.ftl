<#import "macros/all.ftl" as m>
<@m.page "Registratiton">
<#--    Проверка существует ли пользователь с таким никнеймом-->
    <#if usave??>${usave}</#if>
    <form action="/registration" method="post">
        <div><label>Login: <input type="text" name="username"/></label></div>
        <div><label>Password: <input type="password" name="password"/></label></div>
        <!--Обязательное поле защита запроса, без него не будет работать-->
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In"></div>
    </form>


</@m.page>