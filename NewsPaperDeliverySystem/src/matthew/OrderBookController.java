package matthew;


public interface OrderBookController {
	
	boolean updateOrderBook(OrderBook orderbook);
	void printAllOrderBooks();
	boolean deleteOrderBook(String orderID);
	boolean  getOrderBookById(String orderId);
	 boolean insertOrderBook(OrderBook orderbook);
}
