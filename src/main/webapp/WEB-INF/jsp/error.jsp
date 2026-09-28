<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" import="java.io.PrintWriter" %>
<html>
<head><title>Error - World Atlas</title></head>
<body>
<h1>Something went wrong</h1>
<pre><% if (exception != null) { exception.printStackTrace(new PrintWriter(out)); } %></pre>
</body>
</html>
