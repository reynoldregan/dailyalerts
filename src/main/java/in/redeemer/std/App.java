package in.redeemer.std;

import in.redeemer.util.Task;

/**
 * Class App initiates the Alert service
 * 
 * @author reganr
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Daily Alert App started");
        String fullPath=System.getProperty("user.dir");
        Task task=new Task(fullPath);
        task.run();
        System.out.println("App Exited");
    }
}
