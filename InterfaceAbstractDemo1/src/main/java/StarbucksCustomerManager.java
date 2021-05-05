import java.net.MalformedURLException;

public class StarbucksCustomerManager extends BaseCustomerManager   {
	
	private CustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}



	@Override
	public void Save(Customer customer) throws MalformedURLException {
		if(customerCheckService.tcKimlikNoDogrula(customer)){
			//mernise ba�lanma 
			//System.out.println("Kullan�c� kaydedildi : "+customer.getFirstName());
			super.Save(customer);
		}
		else {
			System.out.println("Not a valid person.");
		}
		
	}
	/*
	private void CheckIfRealPerson(Customer customer) {
		//Mernis kontrol kodlar� buraya yaz�labilir
		//mernis ba�lanma kodlar� 
		//bunu burada koymayacaks�n ��nk� solid in s si
		//bu buraya uymaz
		//bunu interface e al�caz
	}
	*/



	public boolean tcKimlikNoDogrula(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}

	

	
}
