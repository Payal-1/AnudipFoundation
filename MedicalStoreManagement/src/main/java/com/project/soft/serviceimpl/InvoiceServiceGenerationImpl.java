package com.project.soft.serviceimpl;

import java.time.LocalDateTime;
import java.util.List;

import com.project.soft.entity.BillItem;
import com.project.soft.entity.Billing;
import com.project.soft.entity.Customer;
import com.project.soft.services.InvoiceGenerationService;

public class InvoiceServiceGenerationImpl implements InvoiceGenerationService {

	@Override
	  public String generateInvoice(Billing billing) {
	        // Get billing details
	        LocalDateTime billingDateTime = billing.getBillingDateTime();
	        double totalAmount = billing.getTotalAmount();
	        Customer customer = billing.getCustomer();
	        
	        // Get items associated with the billing
	        List<BillItem> billItems = billing.getBillItems();
	        
	        // Prepare the invoice content (example shown here)
	        StringBuilder invoiceContent = new StringBuilder();
	        
	        invoiceContent.append("Invoice Date: ").append(billingDateTime).append("\n");
	        invoiceContent.append("Customer: ").append(customer.getName()).append("\n");
	        invoiceContent.append("Items Purchased:\n");
	        
	        for (BillItem billItem : billItems) {
	            invoiceContent.append("- ").append(billItem.getDrug().getName())
	                .append(": Quantity - ").append(billItem.getQuantity())
	                .append(", Price/Unit - ").append(billItem.getDrug().getPrice())
	                .append(", Total - ").append(billItem.getItemTotal()).append("\n");
	        }
	        
	        invoiceContent.append("\nTotal Amount: ").append(totalAmount);
	        
	        // For simplicity, returning invoice content as a string
	        return invoiceContent.toString();
	    
	}


}
