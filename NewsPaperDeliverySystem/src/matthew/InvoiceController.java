package matthew;

//developer. Matthew devlin

public interface InvoiceController {

	boolean updateInvoice(Invoice invoice);
	void printAllInvoices();
	boolean deleteInvoice(String invoiceID);
	boolean  getInvoiceById(String invoiceID);
	 boolean insertInvoice(Invoice invoice);
}
