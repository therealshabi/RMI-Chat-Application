/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmichatapplicationserver;

import com.mycompany.rmichatapplicationclient.ChatClientInterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author shahbaz
 */
public interface ChatServerInterface extends Remote {
    public void registerChatClient(ChatClientInterface chatClient) throws RemoteException;
    public void broadcastMessage(String message) throws RemoteException;
    
}
