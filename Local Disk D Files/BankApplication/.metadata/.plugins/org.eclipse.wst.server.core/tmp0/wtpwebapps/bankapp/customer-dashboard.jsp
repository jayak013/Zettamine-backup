<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:useBean id="service" class="com.zm.bankapp.service.UserServiceImpl"/>
<jsp:useBean id="customer" class="com.zm.bankapp.dto.Customer"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Dashboard</title>
    <link rel="stylesheet" href="admin-dashboard.css"> 
</head>
<body>
    <header>
    <%if(request.getParameter("username")!=null)customer =  service.getCustomerByUserName(request.getParameter("username"));%>
        <h1>Welcome To Customer Dashboard</h1>
        <h1><c:out value="Customer Name: <%=customer.getCustName()%>"/></h1>
        <h1><c:out value="Account Number: <%=customer.getAccountNo()%>"/></h1>
        <h1><c:out value="Balance: <%=service.getBalanceByAccountNo(customer.getAccountNo())%>"/></h1>
        <a href="login.jsp?action=logout" 	class="logout-button">Logout</a>
    </header>

    <main>
        <div class="app-grid">
            <a href="check-balance.jsp" class="app-link">Check Balance</a>
            <a href="transaction.jsp" class="app-link">Deposit</a>
        </div>
    </main>
</body>
</html>
<%request.setAttribute("login", "customer");
%>