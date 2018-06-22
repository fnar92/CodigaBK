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
public class GlobalException extends RuntimeException{
    
     private String errorMessage;
    
    public GlobalException(){
        super();
    }
    
    public GlobalException(String errorMessage)
    {
        super(errorMessage);
        this.errorMessage = errorMessage;        
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    
}
