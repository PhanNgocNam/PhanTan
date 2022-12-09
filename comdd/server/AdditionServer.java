package com.server;

import java.rmi.*;  
import java.rmi.registry.*;

public class AdditionServer{  
	public static void main(String args[]){  
		try{  
			LocateRegistry.createRegistry(2789);
			Naming.bind("rmi://localhost:2789/sonoo",new Addition()); 
		}catch(Exception e){
			System.out.println(e);
		}  
	}  
}