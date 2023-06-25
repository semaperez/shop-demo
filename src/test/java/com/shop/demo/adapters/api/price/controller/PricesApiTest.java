package com.shop.demo.adapters.api.price.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.demo.adapters.api.price.dto.PriceDto;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class PricesApiTest {
    private static final String ROOT_PATH = "/prices";
    private static final String BRAND_ID = "1";
    private static final String PRODUCT_ID = "35455";

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    private MockHttpServletResponse getResponse (String rangeDate) throws Exception {
        return mvc.perform(MockMvcRequestBuilders
                        .get(ROOT_PATH)
                        .param("rangeDate", rangeDate)
                        .param("productId", PRODUCT_ID)
                        .param("brandId", BRAND_ID)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
    }

    private void assertResponse(MockHttpServletResponse response, Integer priceListExpected) throws UnsupportedEncodingException,
            JsonProcessingException {
        assertNotNull(response);
        assertEquals(HttpStatus.OK.value(), response.getStatus());

        PriceDto priceDtoResponse = mapper.readValue(response.getContentAsString(), PriceDto.class);
        assertEquals(Integer.valueOf(PRODUCT_ID), priceDtoResponse.getProductId());
        assertEquals(priceListExpected, priceDtoResponse.getPriceList());
    }

    @Test
    void givenRangeDate1AndProducIdAndBrandId_when_getPrice_thenSuccessReturns() throws Exception {
        MockHttpServletResponse response = getResponse("2020-06-14T10:00:00");
        assertResponse(response,1);
    }

    @Test
    void givenRangeDate2AndProducIdAndBrandId_when_getPrice_thenSuccessReturns() throws Exception {
        MockHttpServletResponse response = getResponse("2020-06-14T16:00:00");
        assertResponse(response,2);
    }

    @Test
    void givenRangeDate3AndProducIdAndBrandId_when_getPrice_thenSuccessReturns() throws Exception {
        MockHttpServletResponse response = getResponse("2020-06-14T21:00:00");
        assertResponse(response,1);
    }

    @Test
    void givenRangeDate4AndProducIdAndBrandId_when_getPrice_thenSuccessReturns() throws Exception {
        MockHttpServletResponse response = getResponse("2020-06-15T10:00:00");
        assertResponse(response,3);
    }

    @Test
    void givenRangeDate5AndProducIdAndBrandId_when_getPrice_thenSuccessReturns() throws Exception {
        MockHttpServletResponse response = getResponse("2020-06-16T21:00:00");
        assertResponse(response,4);
    }
}