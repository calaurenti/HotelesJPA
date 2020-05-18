package hotelesjpa.entity.type;

public enum PaymentMethod {
    /**
     * When a booking is done at Despegar.com, the guest have to pay the full charge to us.
     * Then we have to pay the booking cost (net rate + taxes) to the hotel
     */
    PREPAID,

    /**
     * When a booking is done at Despegar.com, the guest do not have to pay any charge.
     * The charge will be done when he arrives at the hotel.
     * Hotel will have to pay Despegar.com' s commission due to the guest will pay the full charge there.
     */
    PAYMENT_ON_ARRIVAL
}
