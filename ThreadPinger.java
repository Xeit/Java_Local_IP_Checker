import java.net.*;
import java.lang.*;
import java.io.*;
public class ThreadPinger implements Runnable
{
    private Integer x; //Number of set of IPs to check. 

    public ThreadPinger(Integer X)
    {
        this.x = X;
    }

    @Override
    public void run()
    {
        for(Integer y = 0;y<256;y++)
        {
            //Setting up IP to check from set
            String ip = "192.168."+x.toString()+"."+y.toString();
            try
            {
                //Checking the IP
                InetAddress testedIp = InetAddress.getByName(ip);
                if(testedIp.isReachable(200))
                {   
                    //Adding IP to list if it's occupied.
                    Pinger.ipList.add(ip);
                }
            }
            catch(UnknownHostException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("Thread "+ x +" ended");
    }
}
