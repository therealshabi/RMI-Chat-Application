/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmichatapplicationserver;

import com.mycompany.rmichatapplicationclient.ChatClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author shahbaz
 */
public class ChatServer extends UnicastRemoteObject implements ChatServerInterface , java.io.Serializable{

    ArrayList<ChatClientInterface> chatClient;
    public ChatServer() throws RemoteException{
        super();
        chatClient = new ArrayList<>();
    }
    
    @Override
    public synchronized void registerChatClient(ChatClientInterface chatClient) throws RemoteException {
        this.chatClient.add(chatClient);
        System.out.println("Client "+this.chatClient.size()+" connected");
    }

    @Override
    public synchronized void broadcastMessage(String message) throws RemoteException {
        for(int i=0;i<chatClient.size();i++){
            chatClient.get(i).recieveMessage(message);
        }
    }
    
}
