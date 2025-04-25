package std;

import javax.swing.UIManager;

public class WindowUtilities {
    public static void setNativeLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        }
    }

    // Uncomment these lines if you want to use different look and feels
    // UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
}
