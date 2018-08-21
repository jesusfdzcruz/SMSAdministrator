/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smsadministrator.dataaccess;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import smsadministrator.constants.SMSOperations;

/**
 *
 * @author Oni-sama
 */
public class Cellphone {
    
    private String mIP;
    private int mPort;
    
    private int mNumberOfMessages;
    
    public Cellphone(String ip, int port){
        mIP = ip;
        mPort = port;
    }
    
    public boolean sendMessage(String number, String message){
        try{
            Socket socket = new Socket(mIP, mPort);
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            dataOutputStream.writeInt(SMSOperations.SEND_MESSAGE.ordinal());
            
            dataOutputStream.writeChars(number);
            
            dataOutputStream.writeChars(message);
                        
            mNumberOfMessages++;
            return true;
        }
        catch(IOException error){
            error.printStackTrace();
            return false;
        }
    }
    
    public int getmNumberOfMessages() {
        return mNumberOfMessages;
    }

    public void setmNumberOfMessages(int mNumberOfMessages) {
        this.mNumberOfMessages = mNumberOfMessages;
    }

    public String getmIP() {
        return mIP;
    }   
    
}
