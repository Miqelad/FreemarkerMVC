<#import "macros/all.ftl" as m>
    <@m.page "Hello">
        <div>
        <form action="/logout" method="post">
            <input type="submit" value="Sign Out"/>
        </form>

        </div>
        <div>
            <a href="/login">Login</a>
        </div>

    </@m.page>
