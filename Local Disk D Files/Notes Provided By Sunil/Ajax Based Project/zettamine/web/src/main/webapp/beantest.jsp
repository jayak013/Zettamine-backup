<jsp:useBean id="acc" class="com.zettamine.web.models.Account"></jsp:useBean>
<h2>
A/C No: <jsp:getProperty property="accountNo" name="acc"/> <br>
Name: <jsp:getProperty property="accountName" name="acc"/> <br>
Balance: <jsp:getProperty property="accountBal" name="acc"/> <br>
</h2>
<hr>
<h2>
<jsp:setProperty property="accountName" name="acc" value="Sunil Joseph"/>
Name: <jsp:getProperty property="accountName" name="acc"/>
</h2>