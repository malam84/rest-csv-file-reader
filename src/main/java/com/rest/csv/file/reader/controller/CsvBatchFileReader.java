package com.rest.csv.file.reader.controller;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.rest.csv.file.reader.constant.CsvConstant;
import com.rest.csv.file.reader.exceptions.ApiResponseMsg;
import com.rest.csv.file.reader.model.CsvFile;
import com.rest.csv.file.reader.service.CsvFileService;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author malam84
 *
 */

@Log4j2
@RestController
public class CsvBatchFileReader {
	
	@Autowired
	private CsvFileService csvFileService;
	
	@PostMapping("/api/uploadcsvfile")
	public ResponseEntity<Object> uploadCsvFile(@RequestParam("file") MultipartFile file) {
		
		ApiResponseMsg apiRespMsg = new ApiResponseMsg();
		
		try {	
		      Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8")); 
		      CsvToBean<CsvFile> csvToBean = new CsvToBeanBuilder<CsvFile>(reader).withType(CsvFile.class)
		    		  .withIgnoreLeadingWhiteSpace(true).build();
              List<CsvFile> csvFile = csvToBean.parse();
              csvFileService.saveCsvData(csvFile);
		}catch (Exception ex) {
		    log.error(ex.getMessage(), ex);
		    apiRespMsg.setStatusCode(CsvConstant.BadReqCode);
		    apiRespMsg.setStatusMessage(ex.getMessage());
		    return new ResponseEntity<Object>(
		    	apiRespMsg, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
	 
		apiRespMsg.setStatusCode(CsvConstant.SuccessCode);
		apiRespMsg.setStatusMessage(CsvConstant.SuccessMsg);
		return ResponseEntity.ok(apiRespMsg);
	}
}
