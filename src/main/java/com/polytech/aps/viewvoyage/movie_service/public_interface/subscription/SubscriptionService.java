package com.polytech.aps.viewvoyage.movie_service.public_interface.subscription;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription.SubscriptionTypeDto;

import java.util.List;

public interface SubscriptionService {
    List<SubscriptionTypeDto> getAllSubscriptionsInfo();
}
