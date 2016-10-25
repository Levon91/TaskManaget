package com.sfl.taskmanager.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO {

    private int code;

    private String message;

    private Map data;

    public ResponseDTO(HttpStatus status) {
        init(status);
    }

    public ResponseDTO(HttpStatus status, String message) {
        this.message = message;
        init(status);
    }

    public ResponseDTO(HttpStatus status, String message, Map data) {
        this.message = message;
        this.data = data;
        init(status);
    }

    private void init(HttpStatus status) {
        this.code = status.value();
        if (this.message == null || this.message.trim().length() < 0) {
            this.message = status.name();
        }
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map getData() {
        return data;
    }
}
