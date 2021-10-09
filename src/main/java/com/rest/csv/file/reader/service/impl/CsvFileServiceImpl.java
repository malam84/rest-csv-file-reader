package com.rest.csv.file.reader.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.csv.file.reader.dao.CsvFileServiceDao;
import com.rest.csv.file.reader.exceptions.DataManipulationException;
import com.rest.csv.file.reader.model.CsvFile;
import com.rest.csv.file.reader.service.CsvFileService;

/**
 * 
 * @author malam84
 *
 */

@Service
public class CsvFileServiceImpl implements CsvFileService {

	@Autowired
	CsvFileServiceDao csvFileServiceDao;
	
	@Override
	public void saveCsvData(List<CsvFile> lstCsvFile) throws DataManipulationException {
		csvFileServiceDao.saveCsvData(lstCsvFile);
		
	}
}
