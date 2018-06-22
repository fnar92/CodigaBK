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
public class ConflictException extends GlobalException {         

    public ConflictException() {
        super();
    }
    
    public ConflictException(String errorMessage) {
        super(errorMessage);

    }        
    
}
