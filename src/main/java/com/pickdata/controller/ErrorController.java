package com.pickdata.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.java.Log;

@ControllerAdvice
@RequestMapping("/credits")
@Log
public class ErrorController {
	
	
	
			// 400 Error
			@ExceptionHandler(BindException.class)
			public String handleIOException(BindException ex) {
				return "thymeleaf/error/400";
			}

			@ExceptionHandler(HttpMessageNotReadableException.class)
			public String handleIOException(HttpMessageNotReadableException ex) {
				return "thymeleaf/error/400";
			}

			@ExceptionHandler(MethodArgumentNotValidException.class)
			public String handleIOException(MethodArgumentNotValidException ex) {
				return "thymeleaf/error/400";
			}

			@ExceptionHandler(MissingServletRequestParameterException.class)
			public String handleIOException(MissingServletRequestParameterException ex) {
				return "thymeleaf/error/400";
			}

			@ExceptionHandler(MissingServletRequestPartException.class)
			public String handleIOException(MissingServletRequestPartException ex) {
				return "thymeleaf/error/400";
			}

			@ExceptionHandler(TypeMismatchException.class)
			public String handleIOException(TypeMismatchException ex) {
				return "thymeleaf/error/400";
			}

			// 404 Error
			@ExceptionHandler(NoHandlerFoundException.class)
			public String handleIOException(NoHandlerFoundException ex) {
				return "thymeleaf/error/404";
			}

			// @ExceptionHandler(NoSuchRequestHandlingMethodException.class)
			// public String handleIOException(NoSuchRequestHandlingMethodException ex)
			// {
			// return "error/404";
			// }
			// 405 Error
			@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
			public String handleIOException(HttpRequestMethodNotSupportedException ex) {
				return "thymeleaf/error/405";
			}

			// 406 Error
			@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
			public String handleIOException(HttpMediaTypeNotAcceptableException ex) {
				return "thymeleaf/error/406";
			}

			// 415 Error
			@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
			public String handleIOException(HttpMediaTypeNotSupportedException ex) {
				return "thymeleaf/error/415";
			}
			
			// 500 Error
			@ExceptionHandler(ConversionNotSupportedException.class)
			public String handleIOException(ConversionNotSupportedException ex) {
				return "thymeleaf/error/500";
			}

			@ExceptionHandler(HttpMessageNotWritableException.class)
			public String handleIOException(HttpMessageNotWritableException ex) {
				return "thymeleaf/error/500";
			}
			
			@ExceptionHandler(NullPointerException.class)
			public String handleIOException(NullPointerException ex, Model model) {
				model.addAttribute("error", ex);
//				ex.getMessage();
//				ex.getStackTrace();
//				ex.toString();
				return "thymeleaf/error/500";
			}
}
