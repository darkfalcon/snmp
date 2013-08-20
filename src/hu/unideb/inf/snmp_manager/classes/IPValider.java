package hu.unideb.inf.snmp_manager.classes;

/**
 *
 * @author darkfalcon
 */
public class IPValider {
    
    String ip;
    
    public IPValider(String ip) {
        this.ip = ip;
    }
    
    public boolean checkIP() {

        if (ip.isEmpty()) {
            return false;
        }

        String[] parts = ip.split("\\.");
        int n = 0;
        for (String s : parts) {
            n++;
            int i;
            try {
                i = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                return false;
            }

            if (i < 0 || i > 255) {
                return false;
            }
        }
        if (n != 4) {
            return false;
        }
        return true;
    }
    
    public int getMask() {
        String s = ip.substring(0, ip.indexOf("."));
        int firstOctet = Integer.parseInt(s);
        System.out.println(firstOctet);
        if(firstOctet >= 1 && firstOctet < 128) {
            return 8;
        } else if (firstOctet >= 128 && firstOctet < 192) {
            return 16;
        } else {
            return 24;
        }
    }
}
