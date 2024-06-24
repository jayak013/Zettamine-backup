<%!
  String companyName = "ZettaMine Labs Pvt Ltd";
  public int addNum(int x, int y){
	 return x+y;
  }
%>
<h2>
<%
 out.println("My Company is " + companyName + "<br><br>");
 out.println("sum = " + addNum(12,34));
%>
</h2>