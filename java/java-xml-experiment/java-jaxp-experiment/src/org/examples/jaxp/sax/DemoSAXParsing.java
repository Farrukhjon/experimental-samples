/**
 * 
 */
package org.examples.jaxp.sax;

import java.io.File;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Farrukhjon SATTOROV
 *
 */
public class DemoSAXParsing {

	public static void main(String[] args) throws SAXException {
		File xmlFile = new File("users.xml");
		XMLReader reader = XMLReaderFactory.createXMLReader();
	}

}
