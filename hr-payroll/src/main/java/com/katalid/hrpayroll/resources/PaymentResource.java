package com.katalid.hrpayroll.resources;

import com.katalid.hrpayroll.entities.Payment;
import com.katalid.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "geetPaymentAlternative")
    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return ResponseEntity
                .ok()
                .body(paymentService.getPayment(workerId, days));
    }

    public ResponseEntity<Payment> geetPaymentAlternative(Long workerId, Integer days) {
        Payment payment = new Payment("Brann",400.00,days);
        return ResponseEntity
                .ok()
                .body(payment);
    }
}
