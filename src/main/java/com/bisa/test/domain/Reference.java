package com.bisa.test.domain;

import jakarta.persistence.*;


@Entity
@Table(name = "reference")
public class Reference {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "client_reference_id", referencedColumnName = "id")
    private Client clientReferenceId;

    @Column(name = "detail")
    private String detail;

    public Reference(Client client, Client clientReferenceId, String detail) {
        this.client = client;
        this.clientReferenceId = clientReferenceId;
        this.detail = detail;
    }

    public Reference() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClientReferenceId() {
        return clientReferenceId;
    }

    public void setClientReferenceId(Client clientReferenceId) {
        this.clientReferenceId = clientReferenceId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}