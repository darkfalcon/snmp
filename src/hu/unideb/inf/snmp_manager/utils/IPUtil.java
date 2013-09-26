package hu.unideb.inf.snmp_manager.utils;

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

    public String getSubnet(String ip, String netmask) {
        if (checkIP(ip) && checkNetmask(netmask)) {
            int length = Integer.parseInt(netmask);

            char[] mask = new char[32];
            for (int i = 0; i < 32; i++) {
                if (i < length) {
                    mask[i] = '1';
                } else {
                    mask[i] = '0';
                }
            }

            String[] parts = ip.split("\\.");
            char[] ip_tmp = new char[32];
            int oct = 0;
            
            for (String s : parts) {
                int num = Integer.parseInt(s);
                s = Integer.toBinaryString(num);
                StringBuilder sb = new StringBuilder();
                if (s.length() < 8) {
                    for (int i = 0; i < (8 - s.length()); i++) {
                        sb.append('0');
                    }
                    s = new StringBuilder(sb.toString()).append(s).toString();
                }
                
                for (int i = oct; i < oct + 8; i++) {
                    ip_tmp[i] = s.charAt(i % 8);
                }
                oct += 8;
//                System.out.println(oct);
//                System.out.println(s);
            }
            
            for (int i = 0; i < 32; i++) {
                if (ip_tmp[i] != mask[i])
                    ip_tmp[i] = '0';
            }
            
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = (i * 8); j < ((i + 1) * 8); j++) {
                    sb.append(ip_tmp[j]);
                }
                builder.append(String.valueOf(Integer.parseInt(
                        sb.toString(), 2)));
                if (i < 3) {
                    builder.append('.');
                }
            }
            
//            System.out.println("ip:");
//            for (int i = 0; i < 32; i++) {
//                if (i % 8 == 0)
//                    System.out.print(".");
//                System.out.print(ip_tmp[i]);
//            }
//            System.out.println("\nmask:");
//
//            for (int i = 0; i < 32; i++) {
//                System.out.print(mask[i]);
//            }
//            System.out.println("\n");
//            
//            for (String s: octets) {
//                System.out.println(s);
//            }
            
            return builder.toString();
        }
        return null;
    }
}
