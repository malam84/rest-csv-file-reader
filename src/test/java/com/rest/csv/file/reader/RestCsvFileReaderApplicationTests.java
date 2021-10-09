package com.rest.csv.file.reader;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * 
 * @author malam84
 *
 */

@AutoConfigureMockMvc
@SpringBootTest
@DisplayName("CvsFileReaderTest")
class RestCsvFileReaderApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	@DisplayName("Uploading csv file using rest api batch processing")
	public void uploadCsvFileTest() throws Exception {
		
	    InputStream uploadStream = RestCsvFileReaderApplicationTests.class.getClassLoader()
	    		.getResourceAsStream("sales.csv");
	    
	    MockMultipartFile mockMultipartFile = new MockMultipartFile("file", uploadStream);
	    this.mockMvc.perform(MockMvcRequestBuilders.multipart("/api/uploadcsvfile").
	    		file(mockMultipartFile)).andExpect(status().isOk()).andDo(print());
	}

}
