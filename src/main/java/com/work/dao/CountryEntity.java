package com.work.dao;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class CountryEntity {
    private String code;
    private String name;
    private int population;
    private Integer capital;

    public CountryEntity(){  }

    public CountryEntity(String code, String name, int population, Integer capital){
        this.code = code;
        this.name = name;
        this.population = population;
        this.capital = capital;
    }

    @Id
    @Column(name = "Code", nullable = false, length = 3)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 52)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Population", nullable = false)
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Basic
    @Column(name = "Capital", nullable = true)
    public Integer getCapital() {
        return capital;
    }

    public void setCapital(Integer capital) {
        this.capital = capital;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountryEntity that = (CountryEntity) o;

        if (population != that.population) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + population;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return code + " " + name + " " + population + " " + capital;
    }
}
