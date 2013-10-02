
package hu.unideb.inf.snmp_manager.classes;

public class IpAddress {
    
    private String ip;
    private int mask;
    private boolean isNetworkAddress;

    public IpAddress(String ip, int mask, boolean isNetworkAddress) {
        this.ip = ip;
        this.mask = mask;
        this.isNetworkAddress = isNetworkAddress;
    }

    public String getIp() {
        return ip;
    }

    public int getMask() {
        return mask;
    }

    public boolean isIsNetworkAddress() {
        return isNetworkAddress;
    }
       

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public void setIsNetwork(boolean isNetworkAddress) {
        this.isNetworkAddress = isNetworkAddress;
    }
    
    @Override
    public String toString() {
        return ip + "/" + mask;
    }
    
    
}
