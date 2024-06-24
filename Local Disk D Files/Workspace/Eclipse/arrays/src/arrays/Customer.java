package arrays;

import java.io.Serializable;
import java.util.Objects;

public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int custId;
	private String cusName;
	private transient int otp;
	
	public Customer() {}

	public Customer(int custId, String cusName, int otp) {
		super();
		this.custId = custId;
		this.cusName = cusName;
		this.otp = otp;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", cusName=" + cusName + ", otp=" + otp + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cusName, custId, otp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(cusName, other.cusName) && custId == other.custId && otp == other.otp;
	}
	
}
