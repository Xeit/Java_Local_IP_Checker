import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Collections.*;

public class Pinger
{
    public static List<String> ipList = Collections.synchronizedList(new ArrayList<>());


    public static String getLocalIp()
    {
        String ip = "";
        try
        {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements())
            {
                NetworkInterface face = interfaces.nextElement();
                if(!face.isUp() || face.isVirtual() || face.isPointToPoint() || face.isLoopback())
                    continue;

                Enumeration<InetAddress> addresses = face.getInetAddresses();
                while(addresses.hasMoreElements())
                {
                    InetAddress addr = addresses.nextElement();
                    ip = addr.getHostAddress();


                    if(ip.contains("192.168."))
                    {
                        System.out.println("IP of this machine: " + ip);
                        return(ip);
                    }
                }
            }
        }
        catch(SocketException e)
        {
            e.printStackTrace();
        }
        return("AAA");
    }
    
    public static boolean checkEverything()
    {
        Integer x = 0;
        Thread first = new Thread(new ThreadPinger(0));
        Thread second = new Thread(new ThreadPinger(0));
        Thread third = new Thread(new ThreadPinger(0));
        Thread forth = new Thread(new ThreadPinger(0));
        Thread fifth = new Thread(new ThreadPinger(0));
        Thread sixth = new Thread(new ThreadPinger(0));
        Thread seventh = new Thread(new ThreadPinger(0));
        Thread eighth = new Thread(new ThreadPinger(0));
        while(x < 256 || first.isAlive() || second.isAlive() || third.isAlive() || forth.isAlive() || fifth.isAlive() || sixth.isAlive() || seventh.isAlive())
        {
            if(!first.isAlive() && x < 256)
            {
                first = new Thread(new ThreadPinger(x));
                first.start();
                if(x < 256)
                    x++;
            }
            if(!second.isAlive() && x < 256)
            {
                second = new Thread(new ThreadPinger(x));
                second.start();
                if(x < 256)
                    x++;
            }
            if(!third.isAlive() && x < 256)
            {
                third = new Thread(new ThreadPinger(x));
                third.start();
                if(x < 256)
                    x++;
            }
            if(!forth.isAlive() && x < 256)
            {
                forth = new Thread(new ThreadPinger(x));
                forth.start();
                if(x < 256)
                    x++;
            }
            
            if(!fifth.isAlive() && x < 256)
            {
                fifth = new Thread(new ThreadPinger(x));
                fifth.start();
                if(x < 256)
                    x++;
            }
            if(!sixth.isAlive() && x < 256)
            {
                sixth = new Thread(new ThreadPinger(x));
                sixth.start();
                if(x < 256)
                    x++;
            }
            if(!seventh.isAlive() && x < 256)
            {
                seventh = new Thread(new ThreadPinger(x));
                seventh.start();
                if(x < 256)
                    x++;
            }
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException
    {
        String ip = getLocalIp();
        if(ip.equals("AAA"))
        {
            System.out.println("Cannot get local IP.");
            return;
        }
        checkEverything();

       System.out.println("Main still works");
       Thread.sleep(500);

       for(String string : ipList)
       {
           System.out.println(string);
       }
    }
}
