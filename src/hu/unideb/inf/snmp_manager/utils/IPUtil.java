package hu.unideb.inf.snmp_manager.utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darkfalcon
 */
public class IPUtil {

    public boolean checkIP(String ip) {

        if (ip.isEmpty()) {
            return false;
        }

        String[] parts = ip.split("\\.");
        int n = 0;

        for (String s : parts) {
            n++;
            int i;
            if (s.contains("+") || s.contains("-")) {
                return false;
            }

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

    public boolean checkNetmask(String netmask) {

        int mask;
        try {
            mask = Integer.parseInt(netmask);
            if (mask >= 0 && mask <= 32) {
                return true;
            }
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public int getDefaultMask(String ip) {
        String s = ip.substring(0, ip.indexOf("."));
        int firstOctet = Integer.parseInt(s);
        System.out.println(firstOctet);
        if (firstOctet >= 1 && firstOctet < 128) {
            return 8;
        } else if (firstOctet >= 128 && firstOctet < 192) {
            return 16;
        } else {
            return 24;
        }
    }

    public String getNetworkAddress(String ip, String netmask) {
        int length = Integer.parseInt(netmask);

        String[] ipOctets = ip.split("\\.");
        int[] netmaskOctets = new int[4];

        //Get the netmask prefix in decimal format
        for (int i = 0; i < 4; i++) {
            int n = i * 8;
            for (int j = 7; j >= 0; j--) {
                n++;
                if (n <= length) {
                    netmaskOctets[i] += Math.pow(2, j);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int net = Integer.parseInt(ipOctets[i])
                    & netmaskOctets[i];
            System.out.println(net);
            builder.append(net);
            if (i != 3) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public boolean isNetworkAddress(String ip, String netmask) {
        int length = Integer.parseInt(netmask);

        String[] ipOctets = ip.split("\\.");
        int[] netmaskOctets = new int[4];

        //Get the netmask prefix in decimal format
        for (int i = 0; i < 4; i++) {
            int n = i * 8;
            for (int j = 7; j >= 0; j--) {
                n++;
                if (n <= length) {
                    netmaskOctets[i] += Math.pow(2, j);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int net = Integer.parseInt(ipOctets[i])
                    & netmaskOctets[i];
            System.out.println(net);
            builder.append(net);
            if (i != 3) {
                builder.append(".");
            }
        }
        if (ip.equals(builder.toString())) {
            return true;
        } else {
            return false;
        }
    }
    
    public long getAssignableAddressesCount(String ip, String netmask) { 
        Double ret = (Math.pow(2, (32 - Integer.parseInt(netmask))) -2);
        return ret.longValue();
    }
    
    public List<String> getAssignableAddresses(String ip, String netmask) {
        List ipList = new ArrayList<>();
        
        return ipList;
    }
}
