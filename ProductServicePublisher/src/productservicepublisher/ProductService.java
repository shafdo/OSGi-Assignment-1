package productservicepublisher;
import java.util.List;

public interface ProductService {
	public List<Product> getAllProducts();
	public void displayProductsOrExit();
}
