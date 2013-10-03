/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.snmp_manager.utils;

public class InvalidIpAddressException extends Exception {

    public InvalidIpAddressException() {
    }
    
    public InvalidIpAddressException(Throwable cause) {
        super(cause);
    }

    public InvalidIpAddressException(String message) {
        super(message);
    }
}
