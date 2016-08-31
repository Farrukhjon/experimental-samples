/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.tests;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LogParser {

    public static Collection<Integer> getIdsByMessage(String xml, String message) throws Exception {
        List<Integer> ids = new ArrayList<>();
        DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
        NodeList message1 = parse.getElementsByTagName("message");
        int length = message1.getLength();
        for (int i = 0; i < length; i++) {
            Node item = message1.item(i);
            String nodeValue = item.getFirstChild().getNodeValue();
            if(nodeValue.equals(message)) {
                String id = item.getParentNode().getAttributes().item(0).getNodeValue();
                ids = Arrays.asList(Integer.valueOf(id));
            }
        }
        return ids;
    }

    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<log>\n" +
                        "    <entry id=\"1\">\n" +
                        "        <message>Application started</message>\n" +
                        "    </entry>\n" +
                        "    <entry id=\"2\">\n" +
                        "        <message>Application ended</message>\n" +
                        "    </entry>\n" +
                        "</log>";

        Collection<Integer> ids = getIdsByMessage(xml, "Application ended");
        for (int id : ids)
            System.out.println(id);
    }
}
