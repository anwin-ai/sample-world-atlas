<%@ page contentType="text/html;charset=UTF-8" import="java.util.List,com.worldatlas.model.Country" %>
<html>
<head><title>World Atlas</title></head>
<body>
<h1>World Atlas</h1>
<form action="search" method="get"><input name="q" placeholder="Search countries"><button>Search</button></form>
<p>World population in this atlas: <%= request.getAttribute("worldPopulation") %></p>
<table>
    <tr><th>Country</th><th>Capital</th><th>Continent</th><th>Population</th></tr>
    <% for (Country c : (List<Country>) request.getAttribute("countries")) { %>
    <tr>
        <td><a href="countries?code=<%= c.getCode() %>"><%= c.getName() %></a></td>
        <td><%= c.getCapital() %></td>
        <td><%= c.getContinent() %></td>
        <td><%= c.getPopulation() %></td>
    </tr>
    <% } %>
</table>
</body>
</html>
