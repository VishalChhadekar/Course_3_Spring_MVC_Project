package com.updateuser.error;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.updateuser.entity.ErrorMessage;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public String userNotFoundExceptionHandler(UserNotFoundException exception, WebRequest request, Model model) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		model.addAttribute("errormessage", message);
		return "errors";
	}

	@ExceptionHandler(NullPointerException.class)
	public String nullPointerException(Exception exception, Model model, WebRequest request) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		model.addAttribute("errormessage", message);
		return "errors";
	}

	@ExceptionHandler(InvalidUserData.class)
	public String invalidUserData(InvalidUserData exception, WebRequest request, Model model) {
		ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
		model.addAttribute("errormessage", message);
		return "errors";
	}

}
