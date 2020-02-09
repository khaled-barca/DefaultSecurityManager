import java.io.File;
import java.io.FilePermission;
import java.security.AccessControlContext;
import java.security.AccessController;

public class DefaultSMDemo {
    public static void main(String[] args) {
        AccessControlContext con = AccessController.getContext();
        File file = new File("DefaultSMDemo.policy");
        System.setProperty("java.security.policy", "file:/" + file.getAbsolutePath());
        SecurityManager sm = System.getSecurityManager();
        System.out.println(sm);
        sm.checkPermission(new FilePermission("Data.txt", "read")); // print a message if we passed the check
        System.out.println("allowed");
    }
}
