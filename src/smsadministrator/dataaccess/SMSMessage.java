/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smsadministrator.dataaccess;

/**
 *
 * @author Oni-sama
 */
public class SMSMessage {
    
    private String mDestinationNumber;
    private String mMessage;
    
    public SMSMessage(){}
    
    public SMSMessage(String destinationNumber, String message){
        
        mDestinationNumber = destinationNumber;
        mMessage = message;
    }

    public String getmDestinationNumber() {
        return mDestinationNumber;
    }

    public void setmDestinationNumber(String mDestinationNumber) {
        this.mDestinationNumber = mDestinationNumber;
    }

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }    
}
