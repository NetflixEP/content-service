package com.polytech.aps.viewvoyage.movie_service.rest.subscription;

import com.polytech.aps.viewvoyage.movie_service.public_interface.dto.subscription.SubscriptionTypeDto;
import com.polytech.aps.viewvoyage.movie_service.public_interface.subscription.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/subscriptions")
@Tag(
        name = "Контролер пользовательских подписок",
        description = "Позволяет манипулировать подписками, чтобы изменять пользовательские преимущества"
)
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @GetMapping
    @Operation(
            summary = "Выводим все виды подписок",
            description = "Выводим подробную информацию о возможных подписках, их цене и преимуществах по сравнению с другими"
    )
    public List<SubscriptionTypeDto> getSubscriptions() {
        return subscriptionService.getAllSubscriptionsInfo();
    }
}
