package com.bridgelab.employeepayrollapp.exception;


import com.bridgelab.employeepayrollapp.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class EmployeePayrollExceptionHandler {

    private static final String msg = "Exception while processing REST request";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {


        // Extract validation errors
            log.error("Invalid Date format",ex);
        // Wrap errors inside ResponseDTO
        ResponseDTO responseDTO = new ResponseDTO( msg,"Should be in the format dd-MM-yyyy");

        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(org.springframework.http.converter.HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormatException(org.springframework.http.converter.HttpMessageNotReadableException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Invalid input format");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now().toString());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidDateException(EmployeePayrollException ex) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("error", "Invalid Date");
        errorResponse.put("message", ex.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException ex) {
        ResponseDTO response = new ResponseDTO("Exception while processing REST request", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

