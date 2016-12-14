
public class Customer implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String AccountHoldername;
	float Balance;
	
	public Customer(String name,float amount){
		this.AccountHoldername=name;
		this.Balance=amount;
	}
	
	public void setAccountHoldername(String accountHoldername) {
		AccountHoldername = accountHoldername;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}
	public String getAccountHoldername() {
		return AccountHoldername;
	}
	public float getBalance() {
		return Balance;
	}
}
