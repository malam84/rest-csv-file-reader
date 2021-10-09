package com.rest.csv.file.reader.exceptions;

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
public class ApiResponseMsg {

	  /**
     * The status code.
     */
    private String statusCode;

    /**
     * The status message.
     */
    private String statusMessage;
}