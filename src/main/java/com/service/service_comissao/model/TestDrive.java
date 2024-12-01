package com.service.service_comissao.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "testdrive")
public class TestDrive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data", nullable = false)
    private LocalDate date;

    @Column(name = "nome_do_cliente", nullable = false)
    private String clientName;

    @Column(name = "nome_do_veiculo", nullable = false)
    private String vehicleName;


    public TestDrive() {}
    private TestDrive(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.clientName = builder.clientName;
        this.vehicleName = builder.vehicleName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



   
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    


    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public static class Builder {
        private Long id;
        private LocalDate date;
        private String clientName;
        private String vehicleName;

       
        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder date(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder vehicleName(String vehicleName) {
            this.vehicleName = vehicleName;
            return this;
        }

        
        public TestDrive build() {
            return new TestDrive(this);
        }
    }

}
