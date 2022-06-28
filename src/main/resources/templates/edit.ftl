<#import "_layout.ftl" as layout>
<@layout.header>
    <div>
        <h3>Edit article</h3>
        <form action="/articles/${article.id}" method ="post">
            <p>
                <input type="text" name ="title" value= "${article.title}">
            </p>
            <p>
                <textarea name="body">${article.body} </textarea>
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/articles/${articles.id}" method="post">
            <input type="submit" name="action" value="oooh weee delete me">
        </form>
    </div>
</@layout.header>