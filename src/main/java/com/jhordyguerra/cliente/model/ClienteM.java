package com.jhordyguerra.cliente.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ClienteM {

    @Id
    private String _id;
    private String dni;
    private String fullName;

}
