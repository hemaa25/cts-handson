public class Main {


    static class Customer {
        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    interface CustomerRepository {
        Customer findCustomerById(int id);
    }

    static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public Customer findCustomerById(int id) {
    
            return new Customer(id, "Customer_" + id);
        }
    }

    static class CustomerService {
        private CustomerRepository repository;

        public CustomerService(CustomerRepository repository) {
            this.repository = repository;
        }

        public void displayCustomer(int id) {
            Customer customer = repository.findCustomerById(id);
            if (customer != null) {
                System.out.println("Customer Found:");
                System.out.println("ID   : " + customer.getId());
                System.out.println("Name : " + customer.getName());
            } else {
                System.out.println("Customer not found.");
            }
        }
    }

    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        service.displayCustomer(101); 
    }
}
