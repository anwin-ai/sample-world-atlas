<%@ page contentType="text/html;charset=UTF-8" import="java.util.List,com.worldatlas.model.Country" %>
<html>
<head><title>Admin - World Atlas</title></head>
<body>
<h1>Update population</h1>
<form method="post" action="population">
    <select name="code">
        <% for (Country c : (List<Country>) request.getAttribute("countries")) { %>
        <option value="<%= c.getCode() %>"><%= c.getName() %></option>
        <% } %>
    </select>
    <input name="population" placeholder="New population">
    <input name="by" placeholder="Your name">
    <button>Save</button>
</form>
</body>
</html>
