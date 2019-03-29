package org.farrukh.experiments.money.service;

import org.farrukh.experiments.money.model.Account;

import java.util.Comparator;

abstract public class AccountsSortStrategy {

    abstract Comparator<Account> sortBy();

}
