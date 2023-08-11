package com.ron.sell.online.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.ron.sell.online.domain.RonsResponse;



@ControllerAdvice
@Slf4j
public class RonsDefaultExceptionHandler {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RonsResponse handleException(final Exception e) {
        logException(e);
        return new RonsResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Some exception occured..rons default exception handler caught it ");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public RonsResponse handleRuntimeException(final Exception e) {
        logException(e);
        return new RonsResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Some run time error occured..rons default exception handler caught it ");
    }


    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public @ResponseBody
    RonsResponse  handleIllegalArgumentException(final IllegalArgumentException exception) {
        final RonsResponse response = new RonsResponse(HttpStatus.BAD_REQUEST.toString(), exception.getMessage());
        return response;
    }

    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public RonsResponse handleAccessDeniedException(final AccessDeniedException e) {
        log.warn("!!!! Access Denied: {} !!!!", e.getMessage());
        return new RonsResponse(HttpStatus.FORBIDDEN.toString(), "Access denied");
    }

    /*
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseBody
    public RonsResponse handleUnAuthorizedException(final UnAuthorizedException e) {
        log.warn("!!!! Access Denied: {} !!!!", e.getMessage());
        return new RonsResponse(HttpStatus.UNAUTHORIZED.toString(), "Access denied");
    }
    */

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public
    @ResponseBody
    RonsResponse handleMethodArgumentTypeMismatchException(final Exception e) {
        final RonsResponse response = new RonsResponse(HttpStatus.BAD_REQUEST.toString(), "method argument type mismatch");
        return response;
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public
    @ResponseBody
    RonsResponse handleHttpMessageNotReadableException(final Exception e) {
        final RonsResponse response = new RonsResponse(HttpStatus.BAD_REQUEST.toString(), "Payload invalid, verify that data types match specification");
        return response;
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({HttpClientErrorException.class})
    public @ResponseBody
    RonsResponse handleHttpClientErrorException(final HttpClientErrorException e) {
        log.warn("Encountered client error exception when calling an external rest service, returning http status 500", e);
        return new RonsResponse(HttpStatus.INTERNAL_SERVER_ERROR.toString(), "External service error");
    }

    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler({ResourceAccessException.class})
    @ResponseBody
    public RonsResponse handleResourceAccessException(final ResourceAccessException e) {
        log.warn("Encountered resource access exception when calling an external rest service, returning http status 503", e);
        return new RonsResponse(HttpStatus.SERVICE_UNAVAILABLE.toString(), "Resource unavailable");
    }

    private void logException(final Exception e) {
        log.error("Caught exception: ", e);
    }

}
