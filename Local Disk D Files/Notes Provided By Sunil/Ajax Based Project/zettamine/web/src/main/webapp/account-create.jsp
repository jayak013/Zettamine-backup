<jsp:useBean id="acc" class="com.zettamine.web.models.Account"></jsp:useBean>
<jsp:setProperty name="acc"  property="*"/>
<h2>
A/C No: <jsp:getProperty property="accountNo" name="acc"/> <br>
Name: <jsp:getProperty property="accountName" name="acc"/> <br>
Balance: <jsp:getProperty property="accountBal" name="acc"/> <br>
</h2>