
package hu.unideb.inf.snmp_manager.utils;

public class Language {
    
    private int id;
    private String name;
    private String locale;
    private String country;

    public Language() {
    }

    public Language(int id, String name, String locale, String country) {
        this.id = id;
        this.name = name;
        this.locale = locale;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getLocale() {
        return locale;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" + "id=" + id + ", name=" + name + ", locale="
                + locale + ", country=" + country + '}';
    }
}
