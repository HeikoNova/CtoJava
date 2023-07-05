import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Platform;
import com.sun.jna.*;
public class TestDll {
    static{
        try {
            System.loadLibrary("MyDll");
        }
        catch (UnsatisfiedLinkError e) {
            System.err.println("Native code library failed to load.\n" + e);
            System.exit(1);
        }

        }
public interface myInterface extends Library {
        void test(int n, int i  );
        //void request(int r, String s);
        void getMe(String t);
        myInterface INSTANCE = (myInterface) Native.loadLibrary("MyDll",myInterface.class);
}
    public interface myNextInterface extends Library {
        //void test(int n, int i  );
        //void request(int r, String s);
        void Request(int p, String t);
        void Request1(int p, String t);
        myNextInterface INSTANCE = (myNextInterface)  Native.loadLibrary("C:\\Users\\RD-Administator\\source\\repos\\rolemanager22\\RoleManager-Src\\bin\\x64\\RU_DE\\RM_API.DLL",myNextInterface.class);
    }

    public static void main(String argv[])
    {
        String s = "s";
        myInterface mI = myInterface.INSTANCE;
        mI.test(2,1);
        mI.test(3,4);
        //mI.request(3, s);
        mI.getMe("Ich sehe dich");
        myNextInterface mNI = myNextInterface.INSTANCE;
        //mNI.Request1(1,"s");
        mNI.Request(1,"s");
var path = System.getProperty("java.library.path");


    }

}
