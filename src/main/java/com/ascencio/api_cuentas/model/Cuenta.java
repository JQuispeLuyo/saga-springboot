package com.ascencio.api_cuentas.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cuenta")
public class Cuenta {

    @Id
    private String _id;
    private String id_cliente;
    private Double saldo;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
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
                ", id_cliente='" + id_cliente + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
