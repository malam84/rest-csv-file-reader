package com.rest.csv.file.reader.service;

import java.util.List;

import com.rest.csv.file.reader.exceptions.DataManipulationException;
import com.rest.csv.file.reader.model.CsvFile;

/**
 * 
 * @author malam84
 *
 */

public interface CsvFileService {

	 public void saveCsvData(List<CsvFile> lstCsvFile) throws DataManipulationException;
}
