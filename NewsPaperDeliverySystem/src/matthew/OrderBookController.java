package matthew;
//developer. Matthew devlin


public interface OrderBookController {
	
	boolean updateOrderBook(OrderBook orderbook);
	void printAllOrderBooks();
	boolean deleteOrderBook(String orderID);
	boolean  getOrderBookById(String orderID);
	 boolean insertOrderBook(OrderBook orderbook);
}
