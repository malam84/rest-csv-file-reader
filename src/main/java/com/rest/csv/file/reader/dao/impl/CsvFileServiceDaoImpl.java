package com.rest.csv.file.reader.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rest.csv.file.reader.dao.CsvFileServiceDao;
import com.rest.csv.file.reader.exceptions.DataManipulationException;
import com.rest.csv.file.reader.model.CsvFile;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author malam84
 *
 */

@Log4j2
@Repository
public class CsvFileServiceDaoImpl implements CsvFileServiceDao {

	/** The jdbc template. */
    private JdbcTemplate jdbcTemplate;
    
    /** query from properties file. */
    @Value("${csvfile.insert}")
    private String batchInsertCsvFile;
    
    /**
     * Sets the data source.
     *
     * @param dataSource the new data source
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public void saveCsvData(List<CsvFile> lstCsvFile) throws DataManipulationException {
		try (Connection conn = jdbcTemplate.getDataSource().getConnection(); 
	            PreparedStatement prepStmt = conn.prepareStatement(batchInsertCsvFile);) {
			     for(CsvFile csvFile : lstCsvFile) {
			    	  prepStmt.setString(1, csvFile.getOrderId());
			    	  prepStmt.setString(2, csvFile.getOrderDate()); 
			    	  prepStmt.setString(3, csvFile.getShipDate()); 
			    	  prepStmt.setString(4, csvFile.getShipMode());
			    	  prepStmt.setInt(5, csvFile.getQuantity());
			    	  prepStmt.setFloat(6, csvFile.getDiscount());
			    	  prepStmt.setFloat(7, csvFile.getProfit());
			    	  prepStmt.setString(8, csvFile.getProductId());
			    	  prepStmt.setString(9, csvFile.getCustomerName());
			    	  prepStmt.setString(10, csvFile.getCategory());
			    	  prepStmt.setString(11, csvFile.getCustomerId());
			    	  prepStmt.setString(12, csvFile.getProductName());
			    	  prepStmt.addBatch();
			     }
	            
	            prepStmt.executeBatch();
	            prepStmt.clearBatch();
	        } catch (SQLException e) {
	            log.error(e.getMessage(), e);
	            throw new DataManipulationException(e.getMessage());
	        }
		
	}
}
