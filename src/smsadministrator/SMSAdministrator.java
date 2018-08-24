
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smsadministrator;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import smsadministrator.business.OperatorsList;
import smsadministrator.business.SMSWorker;

import smsadministrator.constants.StringConstants;

import smsadministrator.business.operators.SMSCleanMessages;
import smsadministrator.business.operators.SMSSend;
import smsadministrator.business.operators.SMSAdd;
import smsadministrator.business.operators.SMSHelp;
import smsadministrator.business.operators.SMSRemove;

/**
 *
 * @author Oni-sama
 */
public class SMSAdministrator {
    
    private static OperatorsList operators;
    
    private static SMSWorker mSMSWorker;
    
    private static boolean stopApplication;

    private static void initialize() {
        operators = OperatorsList.getInstance();        
        
        mSMSWorker = SMSWorker.getInstance();
        
        operators.addOperator(SMSAdd.getInstance().getCommand(), SMSAdd.getInstance());
        operators.addOperator(SMSSend.getInstance().getCommand(), SMSSend.getInstance());
        operators.addOperator(SMSCleanMessages.getInstance().getCommand(), SMSCleanMessages.getInstance());
        operators.addOperator(SMSRemove.getInstance().getCommand(), SMSRemove.getInstance());
        operators.addOperator(SMSHelp.getInstance().getCommand(), SMSHelp.getInstance());
    }

    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Locale locale = new Locale("es", "ES");
        String command;
        stopApplication = true;
        
        initialize();
        
        DataInputStream terminal = new DataInputStream(System.in);
        
        //start thread for receiving messages to the queue
        //configure until time
        while(stopApplication){
            System.out.print(CURSOR_STRING);
            command = terminal.readLine();
            

            runCommand(command);
        }
    }
    private static final String CURSOR_STRING = ">";

    private static void runCommand(String command) {
        var commandAndParameters = command.split(StringConstants.COMMAND_SEPARATOR);
        
        evaluator(commandAndParameters[0], commandAndParameters);
    }

    private static void evaluator(String command, String[] parameters) {
        
        var operator = operators.getOperator(command);
        
        if(operator == null)
            printHelp();
        else
            operator.execOperator(parameters);
    }   

    private static void printHelp() {
        
        operators.printHelp();
    }
}
