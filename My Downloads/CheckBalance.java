import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.JSONObject;

import com.zettamine.web.configs.DBHandler;


@WebServlet("/search")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("entered");
		String custId = request.getParameter("custid"); 
		PrintWriter out = response.getWriter();
		try {
			Connection con = DBHandler.establishConnection();
			PreparedStatement pst = con.prepareStatement("select account_no,balance from bank_app.account where cust_id = ?");
			pst.setInt(1, Integer.parseInt(custId));
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int accNo = rs.getInt(1);
				BigDecimal bal = rs.getBigDecimal(2);
				
				response.setContentType("application/json");
				System.out.println("rs");
				JSONObject jObj = new JSONObject();
				jObj.put("accountno",accNo);
				jObj.put("bal",bal);
				System.out.println(accNo);
				System.out.println(bal);
				out.print(jObj);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}