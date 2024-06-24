<%!
  String companyName = "ZettaMine Labs Pvt Ltd";
  public int addNum(int x, int y){
	 return x+y;
  }
%>
<h2>
My Company Name = <%=companyName %>
<br><br>
<%="Sum = " + addNum(43,12) %>
</h2>