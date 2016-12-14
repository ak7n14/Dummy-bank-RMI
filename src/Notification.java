
public class Notification implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accountHolder;
	float amount;
	
	public Notification(String accountHolder,float amount){
		this.accountHolder=accountHolder;
		this.amount=amount;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}
	public Notification() {
		// TODO Auto-generated constructor stub
	}public float getAmount() {
		return amount;
	}
	
}
