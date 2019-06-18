package com.naijatravelshop.service.hotel.util;

import com.naijatravelshop.service.hotel.pojos.request.JacTravelApiCredential;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Bruno on
 * 15/04/2019
 */
@Service
public class Util<T> {
    @Value("${jactravel_client_api_url}")
    private String clientApiUrl;

    public String jaxbObjectToXML(T t) {
        String xml = "";
        try {
            JAXBContext context = JAXBContext.newInstance(t.getClass());
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter writer = new StringWriter();
            m.marshal(t, writer);
            // m.marshal(t, System.out);

            xml = writer.toString();

            if (xml.contains("<?xml")) {
                xml = xml.substring(xml.indexOf("?>") + 3);
            }
            try {
                xml = URLEncoder.encode(xml, "UTF-8");
                xml = "Data=" + xml;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JAXBException e) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, e);
        }
        return xml;
    }

    public String makeApiCall(String requestBody) {
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(clientApiUrl);

            // add header
            post.setHeader("Accept-Encoding", "gzip, deflate");
            post.setHeader("Content-Type", "application/x-www-form-urlencoded");
            post.setHeader("Host", "xmlintegrations.jactravel.com");
            post.setEntity(new StringEntity(requestBody));

            org.apache.http.HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }




}
