package com.tiktok.server.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseObject {
    private String status;
    private String message;
    private Object data;
}
