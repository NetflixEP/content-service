package com.polytech.aps.viewvoyage.movie_service.core.subscription;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription.SubscriptionTypeDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.subscription.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public List<SubscriptionTypeDto> getAllSubscriptionsInfo() {
        return List.of(
                SubscriptionTypeDto.builder()
                        .code("AAAA")
                        .build());
    }
}
