/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmichatapplicationserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author shahbaz
 */
public class ChatServerDriver {
    
    public static void main(String args[]) throws RemoteException, MalformedURLException{
        Registry registry = LocateRegistry.createRegistry(1600);
        registry.rebind("ChatServer", new ChatServer());
    }
    
}
