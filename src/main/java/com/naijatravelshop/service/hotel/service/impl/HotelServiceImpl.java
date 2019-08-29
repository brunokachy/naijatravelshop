package com.naijatravelshop.service.hotel.service.impl;

import com.naijatravelshop.client.hotel.pojo.response.search_hotel.AmenitieItem;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.BusinessItem;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Hotel;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.LeisureItem;
import com.naijatravelshop.client.hotel.pojo.response.search_hotel.Result;
import com.naijatravelshop.client.hotel.service.GOTWClientService;
import com.naijatravelshop.persistence.model.portal.Setting;
import com.naijatravelshop.persistence.repository.hotel.HotelCityRepository;
import com.naijatravelshop.persistence.repository.portal.SettingRepository;
import com.naijatravelshop.service.hotel.pojo.request.HotelCityDTO;
import com.naijatravelshop.service.hotel.pojo.request.SearchHotelDTO;
import com.naijatravelshop.service.hotel.pojo.response.HotelListReponse;
import com.naijatravelshop.service.hotel.pojo.response.HotelResponse;
import com.naijatravelshop.service.hotel.pojo.response.RoomResponse;
import com.naijatravelshop.service.hotel.service.HotelService;
import com.naijatravelshop.web.constants.ProjectConstant;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Bruno on
 * 12/08/2019
 */
@Service
public class HotelServiceImpl implements HotelService {
    private HotelCityRepository hotelCityRepository;
    private GOTWClientService gotwClientService;
    private SettingRepository settingRepository;

    public HotelServiceImpl(HotelCityRepository hotelCityRepository,
                            GOTWClientService gotwClientService,
                            SettingRepository settingRepository) {
        this.hotelCityRepository = hotelCityRepository;
        this.gotwClientService = gotwClientService;
        this.settingRepository = settingRepository;
    }

    @Cacheable(value = "hotelCityCache", unless = "#result == null")
    @Override
    public List<HotelCityDTO> getAllHotelCity() {
        List<HotelCityDTO> hotelCityDTOS = new ArrayList<>();
        hotelCityRepository.findAll().forEach(hotelCity -> {
            HotelCityDTO hotelCityDTO = HotelCityDTO
                    .builder()
                    .code(hotelCity.getCode())
                    .countryCode(hotelCity.getCountryCode())
                    .countryName(hotelCity.getCountryName())
                    .name(hotelCity.getName())
                    .displayName(hotelCity.getName() + ", " + hotelCity.getCountryName())
                    .build();
            hotelCityDTOS.add(hotelCityDTO);
        });
        return hotelCityDTOS;
    }

    @Override
    public HotelListReponse searchHotel(SearchHotelDTO searchHotelDTO) {
        Result result = gotwClientService.searchHotel(searchHotelDTO);
        Optional<Setting> optionalSetting = settingRepository.findFirstByNameEquals(ProjectConstant.CURRENCY_EXCHANGE_RATE);
        Double exchangeRate = Double.valueOf(optionalSetting.get().getValue());
        List<HotelResponse> hotels = new ArrayList<>();
        List<Double> hotelPrices = new ArrayList<>();
        List<Hotel> resultHotels = result.getHotels();

        for (int i1 = 0, resultHotelsSize = resultHotels.size(); i1 < resultHotelsSize; i1++) {
            Hotel hotel = resultHotels.get(i1);
            List<String> facilities;
            List<String> images;
            List<RoomResponse> rooms = new ArrayList<>();
            List<Double> roomPrices = new ArrayList<>();


            facilities = hotel.getAmenitie().getLanguage().getAmenitieItem().stream().map(AmenitieItem::get__text).collect(Collectors.toList());
            hotel.getLeisure().getLanguage().getLeisureItem().stream().map(LeisureItem::get__text).forEachOrdered(facilities::add);
            hotel.getBusiness().getLanguage().getBusinessItem().stream().map(BusinessItem::get__text).forEachOrdered(facilities::add);
            images = hotel.getImages().getHotelImages().getImage().stream().map(image -> image.getUrl().get__cdata()).collect(Collectors.toList());

            int bound = hotel.getRooms().getRoom().size();
            IntStream.range(0, bound).forEachOrdered(i -> {
                Double roomPrice = Double.valueOf(hotel.getRooms().getRoom().get(i).getRoomType().get(0).getRateBases().getRateBasis().get(0).getTotal()) * exchangeRate;
                roomPrices.add(roomPrice);
                RoomResponse roomResponse = RoomResponse
                        .builder()
                        .name(hotel.getRooms().getRoom().get(i).getRoomType().get(0).getName())
                        .roomPrice(roomPrice)
                        .build();
                rooms.add(roomResponse);
            });
            hotelPrices.add(Collections.min(roomPrices));
            HotelResponse hotelResponse = HotelResponse.builder()
                    .address(hotel.getAddress())
                    .cityCode(hotel.getCityCode())
                    .cityName(hotel.getCityName())
                    .countryCode(hotel.getCountryCode())
                    .countryName(hotel.getCountryName())
                    .facilities(facilities)
                    .fullDescription(hotel.getDescription1().getLanguage().get__cdata())
                    .hotelId(hotel.get_hotelid())
                    .hotelName(hotel.getHotelName())
                    .images(images)
                    .lat(hotel.getGeoPoint().getLat())
                    .lng(hotel.getGeoPoint().getLng())
                    .minimumPrice(Collections.min(roomPrices))
                    .maximumPrice(Collections.max(roomPrices))
                    .rating(hotel.getRating())
                    .rooms(rooms)
                    .smallDescription(hotel.getDescription2().getLanguage().get__cdata())
                    .thumbImageURL(hotel.getImages().getHotelImages().getThumb().get__cdata())
                    .build();

            hotels.add(hotelResponse);
        }

        HotelListReponse hotelResponse = HotelListReponse
                .builder()
                .hotelList(hotels)
                .maximumPrice(Collections.max(hotelPrices))
                .minimumPrice(Collections.min(hotelPrices))
                .totalResult(result.getHotels().size())
                .build();
        return hotelResponse;
    }
}
