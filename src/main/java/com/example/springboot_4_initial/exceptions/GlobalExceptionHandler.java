package com.example.springboot_4_initial.exceptions;

import com.example.springboot_4_initial.services.interfaces.IExcepcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    IExcepcionService iExcepcionService;

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleJsonParseError(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(iExcepcionService.generateMessageException(
                        "Formato JSON invalido o tipo de datos incorrecto",
                        "El campo id debe ser numérico",
                        ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMisMatchError(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(iExcepcionService.generateMessageException(
                        "Formato JSON inválido o tipo de dato incorrecto",
                        "El parametro id debe ser numérico",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResourceFoundError(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(iExcepcionService.generateMessageException(
                        "Recurso no encontrado",
                        "El recurso no fue localizado dentro del proyecto",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingParamError(MissingServletRequestParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(iExcepcionService.generateMessageException(
                        "Parametro de peticion no encontrado",
                        "El parametro necesario para la peticio  no fue encontrado",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(NotFoundVacancys.class)
    public ResponseEntity<?> handleNotFoundVacancyError(NotFoundVacancys ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(iExcepcionService.generateMessageException(
                        "Ocurrio un error en el metodo de listado",
                        "El listado de vacantes disponibles se encuentra vacio",
                        ex.getMessage()
                ));
    }

    @ExceptionHandler(NotFoundVacancy.class)
    public ResponseEntity<?> handleNotFoundVacancyError(NotFoundVacancy ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(iExcepcionService.generateMessageException(
                        "Ocurrio un error en la busqueda de la vacante",
                        "Ocurrio un error en la busqueda de la vacante",
                        ex.getMessage()
                ));
    }
}
