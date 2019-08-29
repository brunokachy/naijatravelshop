package com.naijatravelshop.client.hotel.service.impl;

import com.naijatravelshop.client.hotel.pojo.request.search_hotel.BookingDetails;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Child;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Children;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Condition;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Customer;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.FieldValues;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Fields;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Filters;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Request;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Return;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Room;
import com.naijatravelshop.client.hotel.pojo.request.search_hotel.Rooms;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Hotel;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Result;
import com.naijatravelshop.client.hotel.service.GOTWClientService;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.service.hotel.pojo.request.RoomDTO;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;
import com.naijatravelshop.web.constants.ProjectConstant;
import com.naijatravelshop.web.exceptions.BadRequestException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Service
public class GOTWClientServiceImpl<T> implements GOTWClientService {

    private SettingRepository settingRepository;

    public GOTWClientServiceImpl(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Value("${dotw.request.command}")
    private String searchHotelCommand;

    @Override
    public Result searchHotel(SearchHotelDTO searchHotelDTO) {

        Result result = searchHotelForPrice(searchHotelDTO);

        if (result.getSuccessful().equalsIgnoreCase("TRUE")) {
            Result hotelDetailResult = searchHotelForDetails(searchHotelDTO, result);
            if (hotelDetailResult.getSuccessful().equalsIgnoreCase("TRUE")) {
                result.setCurrencyShort(hotelDetailResult.getCurrencyShort());
                for (int i = 0; i < result.getHotels().size(); i++) {
                    for (int j = 0; j < hotelDetailResult.getHotels().size(); j++) {
                        Hotel hotel = result.getHotels().get(i);

                        if (hotel.get_hotelid().equals(hotelDetailResult.getHotels().get(j).get_hotelid())) {
                            hotel.setDescription1(hotelDetailResult.getHotels().get(j).getDescription1());
                            hotel.setDescription2(hotelDetailResult.getHotels().get(j).getDescription2());
                            hotel.setHotelName(hotelDetailResult.getHotels().get(j).getHotelName());
                            hotel.setAddress(hotelDetailResult.getHotels().get(j).getAddress());
                            hotel.setCityName(hotelDetailResult.getHotels().get(j).getCityName());
                            hotel.setCityCode(hotelDetailResult.getHotels().get(j).getCityCode());
                            hotel.setCountryCode(hotelDetailResult.getHotels().get(j).getCountryCode());
                            hotel.setCountryName(hotelDetailResult.getHotels().get(j).getCountryName());
                            hotel.setAmenitie(hotelDetailResult.getHotels().get(j).getAmenitie());
                            hotel.setLeisure(hotelDetailResult.getHotels().get(j).getLeisure());
                            hotel.setBusiness(hotelDetailResult.getHotels().get(j).getBusiness());
                            hotel.setRating(hotelDetailResult.getHotels().get(j).getRating());
                            hotel.setImages(hotelDetailResult.getHotels().get(j).getImages());
                            hotel.setGeoPoint(hotelDetailResult.getHotels().get(j).getGeoPoint());
                            hotel.setRooms(hotelDetailResult.getHotels().get(i).getRooms());
                        }
                    }
                }
            } else {
                throw new BadRequestException("Error in retrieving hotel data");
            }
            return result;
        } else {
            throw new BadRequestException("Error in retrieving hotel data");
        }
    }

    private Result searchHotelForPrice(SearchHotelDTO searchHotelDTO) {
        Customer customer = Customer.builder()
                .request(Request.builder()
                        .bookingDetails(prepareBookingDetails(searchHotelDTO))
                        .returns(Return.builder()
                                .filters(Filters.builder()
                                        .city(searchHotelDTO.getCityCode())
                                        .xmlnsa("http://us.dotwconnect.com/xsd/atomicCondition")
                                        .xmlnsc("http://us.dotwconnect.com/xsd/complexCondition")
                                        .noPrice("false")
                                        .build())
                                .build())
                        ._command(searchHotelCommand)
                        .build())
                .build();

        return request(customer);
    }

    private Result searchHotelForDetails(SearchHotelDTO searchHotelDTO, Result searchHotelForPriceResult) {
        List<String> fields = new ArrayList<>();
        fields.add("description1");
        fields.add("description2");
        fields.add("hotelName");
        fields.add("address");
        fields.add("cityName");
        fields.add("cityCode");
        fields.add("countryName");
        fields.add("countryCode");
        fields.add("amenitie");
        fields.add("leisure");
        fields.add("business");
        fields.add("rating");
        fields.add("images");
        fields.add("geoPoint");

        List<String> hotelIds = new ArrayList<>();
        for (int i = 0; i < searchHotelForPriceResult.getHotels().size(); i++) {
            hotelIds.add(searchHotelForPriceResult.getHotels().get(i).get_hotelid());
        }

        Condition condition = Condition.builder()
                .__prefix("a")
                .fieldName("hotelId")
                .fieldTest("in")
                .fieldValues(FieldValues.builder().fieldValue(hotelIds).build())
                .build();

        Customer customer = Customer.builder()
                .request(Request.builder()
                        .bookingDetails(prepareBookingDetails(searchHotelDTO))
                        .returns(Return.builder()
                                .filters(Filters.builder()
                                        .city(searchHotelDTO.getCityCode())
                                        .xmlnsa("http://us.dotwconnect.com/xsd/atomicCondition")
                                        .xmlnsc("http://us.dotwconnect.com/xsd/complexCondition")
                                        .noPrice("true")
                                        .condition(Condition.builder()
                                                .__prefix("c")
                                                .condition(condition).build())
                                        .build())
                                .fields(Fields.builder()
                                        .field(fields)
                                        .build())
                                .build())
                        ._command(searchHotelCommand)
                        .build())
                .build();

        return request(customer);
    }

    private String changeObjectToXML(Customer customer) {
        String xml = "";
        try {
            JAXBContext context = JAXBContext.newInstance(customer.getClass());
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter writer = new StringWriter();
            m.marshal(customer, writer);
            xml = writer.toString();

        } catch (JAXBException e) {
            Logger.getLogger(GOTWClientServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return xml;
    }

    private Result changeStringToObject(String responseBody) {
        Result result = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(responseBody);
            result = (Result) jaxbUnmarshaller.unmarshal(reader);
        } catch (JAXBException ex) {
            Logger.getLogger(GOTWClientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    private Result request(Customer customer) {
        try {
            Optional<Setting> optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.GOTW_HOST_URL);

            HttpClient client = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(optionalSetting.get().getValue());
            System.out.println("Customer " + customer.toString());
            // add header
            post.setHeader("Accept-Encoding", "application/gzip");
            post.setHeader("Content-Type", "text/xml");
            post.setEntity(new StringEntity(changeObjectToXML(customer)));

            org.apache.http.HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return changeStringToObject(result.toString());
        } catch (IOException ex) {
            Logger.getLogger(GOTWClientServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private BookingDetails prepareBookingDetails(SearchHotelDTO searchHotelDTO) {
        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < searchHotelDTO.getRoomDetailList().size(); i++) {
            RoomDTO roomDTO = searchHotelDTO.getRoomDetailList().get(i);
            List<Child> childList = new ArrayList<>();
            for (Integer childDTO : roomDTO.getChildrenAgeList()) {
                Child child = Child.builder()
                        .__text(childDTO.toString())
                        ._runno(String.valueOf(i + 1))
                        .build();
                childList.add(child);
            }
            Children children = Children.builder()
                    ._no(String.valueOf(roomDTO.getNumberOfChildren()))
                    .child(childList)
                    .build();
            Room room = Room
                    .builder()
                    ._runno(String.valueOf(i + 1))
                    .adultsCode(String.valueOf(roomDTO.getNumberOfAdults()))
                    .children(children)
                    .rateBasis("-1")
                    .build();
            rooms.add(room);
        }

        BookingDetails bookingDetails = BookingDetails.builder()
                .fromDate(searchHotelDTO.getCheckInDate())
                .toDate(searchHotelDTO.getCheckOutDate())
                .rooms(Rooms.builder()
                        ._no(String.valueOf(searchHotelDTO.getNumberOfRooms()))
                        .room(rooms)
                        .build())
                .build();

        return bookingDetails;
    }
}
