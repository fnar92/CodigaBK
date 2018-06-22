/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.winit.codiga_backend.exception;

/**
 *
 * @author francisco.acevedo
 */
public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(int statusCode,  String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    
    /**
     * 
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }
}
