package com.project.soft.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	public ResponseEntity<ErrorMessage> handleDrugException(DrugNotFoundException ex, WebRequest request)
	{
		ErrorMessage em =new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	
	public ResponseEntity<ErrorMessage> handleCustomerException(CustomerNotFoundException ex, WebRequest request)
	{
		ErrorMessage em =new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	
	public ResponseEntity<ErrorMessage> handleSupplierException(SupplierNotFoundException ex, WebRequest request)
	{
		ErrorMessage em =new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	
	
	public ResponseEntity<ErrorMessage> handleBillItemException(BillItemNotFoundException ex, WebRequest request)
	{
		ErrorMessage em =new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	
	
	public ResponseEntity<ErrorMessage> handleBillingException(BillingNotFoundException ex, WebRequest request)
	{
		ErrorMessage em =new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
}
