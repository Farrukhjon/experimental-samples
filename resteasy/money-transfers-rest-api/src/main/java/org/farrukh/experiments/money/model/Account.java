package org.farrukh.experiments.money.model;

import org.jboss.resteasy.links.RESTServiceDiscovery;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {

    private RESTServiceDiscovery restServiceDiscovery;

    private int id;

    private int accountNumber;

    private Client client;

    private String currency;

    private double balance;

    public Account() {
    }

    public Account(Client client, String currency, double balance) {
        this.client = client;
        this.currency = currency;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public RESTServiceDiscovery getRestServiceDiscovery() {
        return restServiceDiscovery;
    }

    public void setRestServiceDiscovery(RESTServiceDiscovery restServiceDiscovery) {
        this.restServiceDiscovery = restServiceDiscovery;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
