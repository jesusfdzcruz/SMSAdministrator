/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smsadministrator.business;

import java.util.LinkedList;
import java.util.Queue;

import smsadministrator.dataaccess.SMSMessage;

/**
 *
 * @author Oni-sama
 */
public class SMSMessageQueue {
    
    private static SMSMessageQueue mInstance= null;
    
    private final Queue<SMSMessage> mMessageQueue;
    
    private SMSMessageQueue(){
        
        mMessageQueue = new LinkedList<>();
    }
    
    public static SMSMessageQueue getInstance(){
        
        if(mInstance == null)
            mInstance = new SMSMessageQueue();
        
        return mInstance;
    }
    
    public void addMessage(String destinationAddress, String message){
        
        mMessageQueue.add(new SMSMessage(destinationAddress, message));
    }

    public SMSMessage getNextMessage(){
        
        return mMessageQueue.poll();
    }
}
