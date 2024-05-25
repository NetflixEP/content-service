package com.polytech.aps.viewvoyage.movie_service.rest.subscription;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription.SubscriptionTypeDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.subscription.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v0/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping
    public List<SubscriptionTypeDto> getSubscriptions() {
        return subscriptionService.getAllSubscriptionsInfo();
    }
}
