<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/top.jsp" %>
<title>STAGEMATE</title>
<script>
    <% String message = (String) request.getAttribute("message");
       if (message != null && !message.isEmpty()) { %>
        alert("<%= message %>");
        close();
    <% } %>
</script>
</head>
<body>
<script src="<%= contextPath %>/js/jquery-3.7.0.min.js"></script>
<script src="<%= contextPath %>/js/script_common.js"></script>
</body>
</html>