package com.polytech.aps.viewvoyage.movie_service.core.user;

import com.polytech.aps.viewvoyage.movie_service.core.user.db.SubscriptionTypeRepository;
import com.polytech.aps.viewvoyage.movie_service.core.user.db.entity.SubscriptionType;
import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription.SubscriptionTypeDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.subscription.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionTypeRepository subscriptionTypeRepository;

    @Override
    public List<SubscriptionTypeDto> getAllSubscriptionsInfo() {
        return subscriptionTypeRepository.findAll()
                .stream()
                .map(this::toSubscriptionTypeDto)
                .toList();
    }

    //TODO сделать маппер с помощью map struct для более удобного преобразования типов
    private SubscriptionTypeDto toSubscriptionTypeDto(SubscriptionType subscriptionType) {
        return SubscriptionTypeDto.builder()
                .code(subscriptionType.getCode())
                .description(subscriptionType.getDescription())
                .price(subscriptionType.getPrice())
                .build();
    }
}
