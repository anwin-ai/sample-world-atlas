package com.worldatlas.service;

import com.worldatlas.repository.CountryRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Map;

public class ImportService {

    private final CountryRepository countries;

    public ImportService(CountryRepository countries) {
        this.countries = countries;
    }

    public int importPopulationXml(InputStream xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xml);
        NodeList rows = document.getElementsByTagName("country");
        for (int i = 0; i < rows.getLength(); i++) {
            Element row = (Element) rows.item(i);
            countries.updatePopulation(row.getAttribute("code"), Long.parseLong(row.getAttribute("population")));
        }
        return rows.getLength();
    }

    @SuppressWarnings("unchecked")
    public int importSnapshot(InputStream snapshot) throws Exception {
        try (ObjectInputStream in = new ObjectInputStream(snapshot)) {
            Map<String, Long> populations = (Map<String, Long>) in.readObject();
            populations.forEach(countries::updatePopulation);
            return populations.size();
        }
    }
}
