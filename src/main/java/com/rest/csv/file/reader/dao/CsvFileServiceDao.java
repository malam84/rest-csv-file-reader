package com.rest.csv.file.reader.dao;

import java.util.List;

import com.rest.csv.file.reader.exceptions.DataManipulationException;
import com.rest.csv.file.reader.model.CsvFile;

/**
 * 
 * @author malam84
 *
 */

public interface CsvFileServiceDao {

	 public void saveCsvData(List<CsvFile> lstCsvFile) throws DataManipulationException;
}
