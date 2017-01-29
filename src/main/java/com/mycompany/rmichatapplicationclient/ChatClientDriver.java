/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmichatapplicationclient;

import com.mycompany.rmichatapplicationserver.ChatServerInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author shahbaz
 */
public class ChatClientDriver {
    public static final String URL = "rmi://localhost:1600/ChatServer";
    public static void main(String args[]) throws NotBoundException, MalformedURLException, RemoteException{
      ChatServerInterface chatServer =  (ChatServerInterface)Naming.lookup(URL);
      if(chatServer!=null){
          System.out.println("Welcome to Chat Application");
      }
      Scanner in = new Scanner(System.in);
      System.out.print("Enter name : ");
      String name = in.next();
      ChatClient obj = new ChatClient(name,chatServer);
      Thread thr = new Thread(obj);
      thr.start();
    }
    
}
