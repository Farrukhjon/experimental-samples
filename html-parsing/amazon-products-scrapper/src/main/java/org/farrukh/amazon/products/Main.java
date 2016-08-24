/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.amazon.products;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Main {

    private static final String url = "https://amazon.com/";

    private static final String userAgent = "Mozilla/5.0 (jsoup)";

    private static final int timeout = 5 * 1000;

    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect(url).userAgent(userAgent)
                                 .timeout(timeout).get();
        Element body = document.body();
        String title = document.title();
    }

    public boolean someLibraryMethod() {
        return true;
    }
}
