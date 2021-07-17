import java.net.*;
import java.lang.*;
import java.io.*;
public class ThreadPinger implements Runnable
{
    private Integer x;
    public ThreadPinger(Integer X)
    {
        this.x = X;
    }
    @Override
    public void run()
    {
        for(Integer y = 0;y<256;y++)
        {
            String ip = "192.168."+x.toString()+"."+y.toString();
            try
            {
                InetAddress testedIp = InetAddress.getByName(ip);
                if(testedIp.isReachable(200))
                {   
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
