<%@ page contentType="text/html;charset=UTF-8" import="java.util.List,com.worldatlas.model.Country,com.worldatlas.model.State" %>
<% Country country = (Country) request.getAttribute("country"); %>
<html>
<head><title><%= country.getName() %> - World Atlas</title></head>
<body>
<h1><%= country.getName() %></h1>
<p>Capital: <%= country.getCapital() %> | Population: <%= country.getPopulation() %> | Density: <%= String.format("%.1f", country.getDensity()) %> per km2</p>
<p class="note"><%= request.getAttribute("note") %></p>
<img src="flag?name=<%= country.getCode().toLowerCase() %>.png" alt="Flag">
<h2>States and provinces</h2>
<table>
    <tr><th>Name</th><th>Capital</th><th>Population</th></tr>
    <% for (State s : (List<State>) request.getAttribute("states")) { %>
    <tr><td><%= s.getName() %></td><td><%= s.getCapital() %></td><td><%= s.getPopulation() %></td></tr>
    <% } %>
</table>
<a href="countries">All countries</a>
</body>
</html>
