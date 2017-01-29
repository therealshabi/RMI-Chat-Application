/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmichatapplicationclient;

import com.mycompany.rmichatapplicationserver.ChatServerInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shahbaz
 */
public class ChatClient extends UnicastRemoteObject implements ChatClientInterface, Runnable ,java.io.Serializable{

    private String name;
    private ChatServerInterface chatServer;
    
    public ChatClient(String name, ChatServerInterface chatServer) throws RemoteException{
        this.name = name;  
        this.chatServer = chatServer;
        chatServer.registerChatClient(this);
    }

    @Override
    public void recieveMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        String message;
        while(true){
            message = in.nextLine();
            try {
                this.chatServer.broadcastMessage(this.name +" : "+message);
            } catch (RemoteException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
