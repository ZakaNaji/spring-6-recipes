<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="welcome.title" /> </title>
</head>
<body>
<h2><spring:message code="welcome.message" /> </h2>
Today is ${today}.
this request took: ${processingTime}ms
current local: ${locale}
</body>
</html>
