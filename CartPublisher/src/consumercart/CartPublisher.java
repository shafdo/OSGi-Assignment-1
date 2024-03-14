package consumercart;

public interface CartPublisher {
	void displayProducts();
	void addToCart(int productNum, int quantityreq);
	void displayBill();
	void clearCart();
}
