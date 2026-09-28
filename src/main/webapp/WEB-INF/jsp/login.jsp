<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Sign in - World Atlas</title></head>
<body>
<h1>Sign in</h1>
<p class="error"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %></p>
<form method="post" action="login">
    <input type="hidden" name="returnTo" value="<%= request.getParameter("returnTo") == null ? "" : request.getParameter("returnTo") %>">
    <input name="username" placeholder="Username">
    <input name="password" type="password" placeholder="Password">
    <button>Sign in</button>
</form>
</body>
</html>
