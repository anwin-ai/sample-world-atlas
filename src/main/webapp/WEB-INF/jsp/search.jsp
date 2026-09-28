<%@ page contentType="text/html;charset=UTF-8" import="java.util.List,com.worldatlas.model.Country" %>
<html>
<head><title>Search - World Atlas</title></head>
<body>
<h1>Results for: <%= request.getParameter("q") %></h1>
<ul>
    <% for (Country c : (List<Country>) request.getAttribute("results")) { %>
    <li><a href="countries?code=<%= c.getCode() %>"><%= c.getName() %></a> - <%= c.getCapital() %></li>
    <% } %>
</ul>
<a href="countries">Back</a>
</body>
</html>
