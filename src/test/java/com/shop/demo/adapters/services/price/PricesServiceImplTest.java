package com.shop.demo.adapters.services.price;

import com.shop.demo.adapters.db.entity.PriceEntity;
import com.shop.demo.adapters.db.repository.JpaPriceRepository;
import com.shop.demo.adapters.services.price.mapper.PriceEntityMapper;
import com.shop.demo.domain.model.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PricesServiceImplTest {

    @InjectMocks
    private PricesServiceImpl sut;
    @Mock
    private JpaPriceRepository jpaPriceRepository;
    @Mock
    private PriceEntityMapper priceEntityMapper;

    @Test
    void given_startDateAndProductIdAndBrandId_when_getPrice_listIsReturned(){
        List<PriceEntity> prices = Collections.singletonList(PriceEntity.builder().build());
        when(jpaPriceRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndBrandId(any(),any(),any(),any()))
                .thenReturn(Optional.of(prices));
        when(priceEntityMapper.toDomain(any())).thenReturn(Price.builder().build());
        Price response = sut.getPrice(LocalDateTime.now(),1,2);
        assertNotNull(response);
    }

}