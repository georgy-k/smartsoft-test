package com.example.smartsofttesttask.Services;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class XMLValidation {

    public static void main (String[] args){
        String request ="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Purchase>\n" +
                "    <id>1249018347</id>\n" +
                "    <purchase_item>1235541980</purchase_item>\n" +
                "    <name>Gosha</name>\n" +
                "    <lastname>Ivanov</lastname>\n" +
                "    <age>23</age>\n" +
                "    <count>3</count>\n" +
                "    <amount>123.45</amount>\n" +
                "    <purchase_date>2019-12-22</purchase_date>\n" +
                "</Purchase>";
        //validateXMLSchema(request);
    }

    public static boolean validateXMLSchema(String xmlRequest) throws IOException, SAXException {

//        try {
            File xsdSchema = new File("./src/main/resources/purchase_request.xsd");
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdSchema);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(xmlRequest)));

//        } catch (IOException | SAXException e) {
//            System.out.println("Exception: "+e.getMessage());
//            return false;
//        }
        return true;
    }
}
