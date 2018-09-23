/* Write a multi-class multithreaded program that simulates multiple sleeping barbers, all in one barbershop that has a finite number of chairs in the waiting room. Each customer is instantiated from a single customer class; each barber is instantiated from a single Barber class. */

import java.util.concurrent.*;

public class SleepingBarber extends Thread {

  
     public static Semaphore customers = new Semaphore(0);
     public static Semaphore barber = new Semaphore(0);
     public static Semaphore accessSeats = new Semaphore(1);

  /*  the number of chairs in this barbershop is 5. */

    public static final int CHAIRS = 5;

    public static int numberOfFreeSeats = CHAIRS;

   
/* THE CUSTOMER THREAD */

class Customer extends Thread {
  
  

  				int iD;
  				boolean notCut=true;

  				/* Constructor for the Customer */
    
  				public Customer(int i) {
    							iD = i;
  						       }

  public void run() {   
    		while (notCut) {
		 // as long as the customer is not cut 
      		try {
      		       accessSeats.acquire();  
      		       if (numberOfFreeSeats > 0) { 
       		       System.out.println("Customer " + this.iD + " just sat down.");
       		        numberOfFreeSeats--;  //sitting down on a chair
        		       customers.release();  //notify the barber that there is a customer
        		       accessSeats.release();  // don't need to lock the chairs anymore  
        		      try {
			barber.acquire();  
		               notCut = false; 
        			this.get_haircut();  //cutting...
        		            } catch (InterruptedException ex) {}
      	            }   
     		 else  {  // there are no free seats
        			System.out.println("There are no free seats. Customer " + this.iD + " has left the barbershop.");
       		 	accessSeats.release();  //release the lock on the seats
        			notCut=false;
		      }
     	}
      catch (InterruptedException ex) {}
    }
  }

  /* this method will simulate getting a hair-cut */
  
  public void get_haircut(){
    			System.out.println("Customer " + this.iD + " is getting his hair cut");
    			try {
    				sleep(5050);
    			      } catch (InterruptedException ex) {}
  		          }

}

 
/* THE BARBER THREAD */


class Barber extends Thread {
  
			  public Barber() {}
  
 			 public void run() {
    			while(true) {  // runs in an infinite loop
     				       try {
      					customers.acquire(); // tries to acquire a customer - if none is available he goes to sleep
     				               accessSeats.release(); // at this time he has been wokenup
       					 numberOfFreeSeats++; // one chair gets free
      					barber.release();  // the barber is ready to cut
				               accessSeats.release(); // we don't need the lock on the chairs anymore
     					 this.cutHair();  //cutting...
   				          } catch (InterruptedException ex) {}
    				}
  	}

    /* this method will simulate cutting hair */
   
  public void cutHair(){
    		          System.out.println("The barber is cutting hair");
    			try {
			           sleep(5000);
    			      } catch (InterruptedException ex){ }
 		       }
	}       
  
  /* main method */

  public static void main(String args[]) {
    
    		SleepingBarber barberShop = new SleepingBarber();  //Creates a new barbershop
   		 barberShop.start(); 
  				}

  		public void run(){   
   		Barber b = new Barber();  
   		b.start();  //Ready for another day of work

   		/* This method will create new customers for a while */
    
 		  for (int i=1; i<16; i++) {
     		  Customer aCustomer = new Customer(i);
    		  aCustomer.start();
     		  try {
       			sleep(2000);
     		        } catch(InterruptedException ex) {};
  		 }
  } 
}

