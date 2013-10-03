
package hu.unideb.inf.snmp_manager.classes;

import hu.unideb.inf.snmp_manager.utils.IPUtil;
import hu.unideb.inf.snmp_manager.utils.InvalidIpAddressException;

public class IpAddress {

    private String ip;
    private String netmask;

    public IpAddress(String ip, String netmask) throws
            InvalidIpAddressException {
        
        IPUtil util = new IPUtil();
        if (util.checkIP(ip) && util.checkNetmask(netmask)) {
            this.ip = ip;
            this.netmask = netmask;
        } else {
            throw new InvalidIpAddressException("Invalid ip address or mask");
        }
    }

    public String getIp() {
        return ip;
    }

    public String getNetmask() {
        return netmask;
    }

    public int getNetmaskInt() {
        return Integer.parseInt(netmask);
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setMask(String netmask) {
        this.netmask = netmask;
    }

    public int getDefaultMask() {
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

    public String getNetworkAddress() {
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
    
    public boolean isIsNetworkAddress() {
        String address = getNetworkAddress();
        if (address.equals(ip)) {
            return true;
        } else {
            return false;
        }
    }

    public String getBroadcastAddress() {
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
            System.out.println(net);
            builder.append(net);
            if (i != 3) {
                builder.append(".");
            }
        }

        return builder.toString();
    }

    public boolean isBroadcastAddress() {
        String address = getBroadcastAddress();
        if (address.equals(ip)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return ip + "/" + netmask;
    }
}