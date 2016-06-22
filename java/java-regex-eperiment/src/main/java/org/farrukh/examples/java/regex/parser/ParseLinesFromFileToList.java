package org.farrukh.examples.java.regex.parser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLinesFromFileToList {

    public static void main(String[] args) {
        String fileName = "/accounts.txt";
        ParseLinesFromFileToList linesFromFile = new ParseLinesFromFileToList();
        List<String> rowAccounts = linesFromFile.readRowsToList(fileName);
        List<Account> accounts = linesFromFile.parseToAccounts(rowAccounts);
        System.out.println(accounts);
        accounts.forEach(System.out::println);
    }

    private List<String> readRowsToList(final String fileName) {
        List<String> rowAccounts = new ArrayList<>();
        InputStream inputStream = this.getClass().getResourceAsStream(fileName);
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(new BufferedInputStream(inputStream)))) {
            String rowAccount;
            while ((rowAccount = reader.readLine()) != null) {
                rowAccounts.add(rowAccount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowAccounts;
    }

    private List<Account> parseToAccounts(final List<String> rowAccounts) {
        List<Account> accounts = new ArrayList<>();
        String accountRegEx = "(^ssh)://([a-zA-Z]+):(\\w+)@(\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b):?(\\d*)";
        Pattern pattern = Pattern.compile(accountRegEx);
        for (String a : rowAccounts) {
            Matcher matcher = pattern.matcher(a);
            if (matcher.matches()) {
                String protocol = matcher.group(1);
                String username = matcher.group(2);
                String password = matcher.group(3);
                String host = matcher.group(4);
                String portGroup = matcher.group(5);
                if(portGroup.isEmpty()) {
                    portGroup = "22";
                }
                int port = Integer.valueOf(portGroup);
                accounts.add(new Account(protocol, username, password, host, port));
            }
        }
        return accounts;
    }


}
