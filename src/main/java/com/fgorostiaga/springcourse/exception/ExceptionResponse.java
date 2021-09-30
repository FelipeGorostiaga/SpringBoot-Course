package com.fgorostiaga.springcourse.exception;

import java.util.Date;
import java.util.List;

public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;
    private int status;
    private List<String> validationMessages;

    public ExceptionResponse(Date timestamp, String message, String details, int status) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.status = status;
    }

    public ExceptionResponse(Date timestamp, String message, String details, int status, List<String> validationMessages) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.status = status;
        this.validationMessages = validationMessages;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(List<String> validationMessages) {
        this.validationMessages = validationMessages;
    }
}
