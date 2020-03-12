package com.ascencio.api_cuentas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cuenta")
public class Cuenta {

    @Id
    private String _id;
    private String cliente;
    private Double saldo;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "_id='" + _id + '\'' +
                ", id_cliente='" + cliente + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
