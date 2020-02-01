package demo2;

public class Laptop {
    public void run() {
        System.out.println("Laptop running.\n");
    }

    public void useUSB(USB usb) {
        if (usb != null) {
            usb.open();

            if (usb instanceof Mouse) {
                Mouse m = (Mouse) usb;
                m.click();
            } else if (usb instanceof KeyBoard) {
                KeyBoard kb = (KeyBoard) usb;
                kb.type();
            }

            usb.close();
        }
    }

    public void shutDown() {
        System.out.println("Laptop shutdown.\n");
    }
}
