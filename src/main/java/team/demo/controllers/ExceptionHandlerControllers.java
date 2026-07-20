package team.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import team.demo.response.ApiResponse;

@ControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerControllers {
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception e) {
        e.printStackTrace();
        return ApiResponse.error(e.getMessage());
    }
}
