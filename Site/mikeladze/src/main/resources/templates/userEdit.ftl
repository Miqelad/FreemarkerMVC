<#import "macros/all.ftl" as m>
<@m.page "User editor">
    <form action="/user" method="post">
        <input type="text" value="${user.username}" name = "username">
        <#list roles as role>
        <label><input type="checkbox" name="${role}">${role}</label>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Save</button>
    </form>


</@m.page>