package com.flightmanagementsystem.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception ex, WebRequest request) {

		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentException(MethodArgumentNotValidException ex, WebRequest request) {

		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

		@ExceptionHandler(ClientAlreadyExistsException.class)
	public ResponseEntity<?> handlerAdminAlreadyExistsException(ClientAlreadyExistsException ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(FlightAlreadyExistsException.class)
	public ResponseEntity<?> handlerFlightAlreadyExistsException(FlightAlreadyExistsException ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(BookingAlreadyExistsException.class)
	public ResponseEntity<?> handlerBookingAlreadyExistsException(BookingAlreadyExistsException ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(AirportAlreadyExistsException.class)
	public ResponseEntity<?> handlerAirportAlreadyExistsException(AirportAlreadyExistsException ex, WebRequest request) {
		ErrorDetails error = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
