package com.rest.csv.file.reader.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author malam84
 *
 */

@Getter
@Setter
@NoArgsConstructor
public class CsvFile {

	@CsvBindByName(column = "Order ID")
	private String orderId;
	
	@CsvBindByName(column = "Order Date")
	private String orderDate;
	
	@CsvBindByName(column = "Ship Date")
	private String shipDate;
	
	@CsvBindByName(column = "Ship Mode")
	private String shipMode;
	
	@CsvBindByName(column = "Quantity")
	private int Quantity;
	
	@CsvBindByName(column = "Discount")
	private float discount;
	
	@CsvBindByName(column = "Profit")
	private float profit;
	
	@CsvBindByName(column = "Product ID")
	private String productId;
	
	@CsvBindByName(column = "Customer Name")
	private String customerName;
	
	@CsvBindByName(column = "Category")
	private String Category;
	
	@CsvBindByName(column = "Customer ID")
	private String customerId;
	
	@CsvBindByName(column = "Product Name")
	private String productName;
	
}
