package com.work.dao;

import javax.persistence.*;

@Entity
@Table(name = "countrylanguage")
@IdClass(CountrylanguageEntityPK.class)
public class CountrylanguageEntity {
    private String countryCode;
    private String language;
    private double percentage;

    @Id
    @Column(name = "CountryCode", nullable = false, length = 3)
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Id
    @Column(name = "Language", nullable = false, length = 30)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "Percentage", nullable = false, precision = 1)
    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountrylanguageEntity that = (CountrylanguageEntity) o;

        if (Double.compare(that.percentage, percentage) != 0) return false;
        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = countryCode != null ? countryCode.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
