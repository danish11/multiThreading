package com.danish.multithread;

class TestThreads 
{  public static void main(String [] args) 
{
    System.out.print("1 ");
    synchronized(args)
    {
        System.out.print("2 ");
        try 
        {
                args.wait(); /* Line 11 */
        }
        catch(InterruptedException e){ }
    }
    System.out.print("3 ");
}
}