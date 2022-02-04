package org.kozak.credit.Models.Entities;

import javax.persistence.*;

@Entity
@Table(name = "credit", schema = "public", catalog = "Credit")
public class CreditEntity {
    private Integer creditId;
    private String creditName;
    private double value;
    private CustomerEntity customerById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "creditid", nullable = false)
    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    @Basic
    @Column(name = "creditname", nullable = false, length = 30)
    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    @Basic
    @Column(name = "value", nullable = false, precision = 0)
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreditEntity that = (CreditEntity) o;

        if (creditId != that.creditId) return false;
        if (customerById != that.customerById) return false;
        if (Double.compare(that.value, value) != 0) return false;
        if (creditName != null ? !creditName.equals(that.creditName) : that.creditName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = creditId;
        result = 31 * result + (creditName != null ? creditName.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "id", nullable = false)
    public CustomerEntity getCustomersById() {
        return customerById;
    }

    public void setCustomersById(CustomerEntity customerById) {
        this.customerById = customerById;
    }
}

