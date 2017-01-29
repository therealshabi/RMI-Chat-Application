/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmichatapplicationclient;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author shahbaz
 */
public interface ChatClientInterface extends Remote {
    public void recieveMessage(String message) throws RemoteException;
    
}
