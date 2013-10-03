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
        
        int count = 0;
        char[] chars = ip.toCharArray();
        for (char c: chars) {
            if (c == '.')
                count++;
        }
        
        if (count > 3) {
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
        //System.out.println(firstOctet);
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
            //System.out.println(net);
            builder.append(net);
            if (i != 3) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public boolean isNetworkAddress(String ip, String netmask) {
        String address = getNetworkAddress(ip, netmask);
        if (address.equals(ip)) {
            return true;
        } else {
            return false;
        }
    }

    public String getBroadcastAddress(String ip, String netmask) {
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
                    | (netmaskOctets[i] ^ 255);
            //System.out.println(net);
            builder.append(net);
            if (i != 3) {
                builder.append(".");
            }
        }

        return builder.toString();
    }

    public boolean isBroadcastAddress(String ip, String netmask) {
        String address = getBroadcastAddress(ip, netmask);
        if (address.equals(ip)) {
            return true;
        } else {
            return false;
        }
    }

    public long getAssignableAddressesCount(String ip, String netmask) {
        Double ret = (Math.pow(2, (32 - Integer.parseInt(netmask))) - 2);
        return ret.longValue();
    }

    public List<String> getAssignableAddresses(String ip, String netmask) {
        List ipList = new ArrayList<>();

        int numberOfBits;
        int ipNumeric = 0;
        int netmaskNumeric = 0;

        String[] ipOctets = ip.split("\\.");
        int[] netmaskOctets = new int[4];
        int length = Integer.parseInt(netmask);

        //Convert prefix to decimal format
        for (int i = 0; i < 4; i++) {
            int n = i * 8;
            for (int j = 7; j >= 0; j--) {
                n++;
                if (n <= length) {
                    netmaskOctets[i] += Math.pow(2, j);
                }
            }
        }

        //Create a numeric format from ip octets
        int num = 24;
        for (int i = 0; i < ipOctets.length; i++) {

            int value = Integer.parseInt(ipOctets[i]);
            ipNumeric += value << num;
            num -= 8;
            //System.out.println(ipNumeric);
        }

        //Create a numeric format from netmask octets
        num = 24;
        for (int i = 0; i < netmaskOctets.length; i++) {
            
            netmaskNumeric += netmaskOctets[i] << num;
            num -= 8;
            //System.out.println(netmaskNumeric);
        }

        for (numberOfBits = 0; numberOfBits < 32; numberOfBits++) {
            if ((netmaskNumeric << numberOfBits) == 0) {
                break;
            }
        }

        Long numberOfIPs = getAssignableAddressesCount(ip, netmask) + 2;
        Integer baseIP = ipNumeric & netmaskNumeric;

        for (int i = 1; i < (numberOfIPs) && i < numberOfIPs; i++) {

            Integer address = baseIP + i;

            StringBuilder sb = new StringBuilder();

            for (int shift = 24; shift > 0; shift -= 8) {

                // process 3 bytes, from high order byte down.
                sb.append(Integer.toString((address >>> shift) & 0xff));
                sb.append('.');
            }
            sb.append(Integer.toString(address & 0xff));
            ipList.add(sb.toString());
        }
        return ipList;
    }
}
