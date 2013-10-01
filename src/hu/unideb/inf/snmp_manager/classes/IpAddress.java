
package hu.unideb.inf.snmp_manager.classes;

public class IpAddress {
    
    private String ip;
    private int mask;
    private boolean isNetwork;

    public IpAddress(String ip, int mask) {
        this.ip = ip;
        this.mask = mask;
    }

    public String getIp() {
        return ip;
    }

    public int getMask() {
        return mask;
    }

    public boolean isIsNetwork() {
        return isNetwork;
    }
       

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setMask(int mask) {
        this.mask = mask;
    }

    public void setIsNetwork(boolean isNetwork) {
        this.isNetwork = isNetwork;
    }
    
    @Override
    public String toString() {
        return ip + "/" + mask;
    }
    
    
}
