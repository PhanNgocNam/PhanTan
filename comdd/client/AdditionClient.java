package com.client;

import java.rmi.*;
import com.adding.AdditionInterface;

public class AdditionClient{  

	public static void main(String args[]){ 
		try{  
			System.out.println("ok");
			try {
				AdditionInterface stub=(AdditionInterface) Naming.lookup("rmi://localhost:2789/sonoo");  
//				stub.add(34, 4);
				System.out.println(stub.add(34,4));
			}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}catch(Exception e){}  
	}
}