package hotelesjpa.entity;

import hotelesjpa.entity.type.PaymentMethod;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "BO_COMMISSIONED_PAYMENT_METHOD")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PAYMENT_METHOD", discriminatorType = DiscriminatorType.STRING)
public class CommissionedPaymentMethod {
    public static final String DISCRIMINATOR_PREPAID = "PREPAID";
    public static final String DISCRIMINATOR_PAYMENT_ON_ARRIVAL = "PAYMENT_ON_ARRIVAL";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private  Long id;

    @Column(name = "MINIMUM_COMMISSION", precision = 4, scale = 4)
    private BigDecimal commission;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "BO_CHANNEL_COMMISSIONS", joinColumns = @JoinColumn(name = "COMMISSIONED_PAYMENT_METHOD_ID"))
    private Set<ChannelCommission> finalCommissions;

    @Column(name = "HOTEL_COMMISSION_PAYMENT", length = 31)
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public CommissionedPaymentMethod(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getDiscriminatorPrepaid() {
        return DISCRIMINATOR_PREPAID;
    }

    public static String getDiscriminatorPaymentOnArrival() {
        return DISCRIMINATOR_PAYMENT_ON_ARRIVAL;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Set<ChannelCommission> getFinalCommissions() {
        return finalCommissions;
    }

    public void setFinalCommissions(Set<ChannelCommission> finalCommissions) {
        this.finalCommissions = finalCommissions;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CommissionedPaymentMethod that = (CommissionedPaymentMethod) o;
        return Objects.equals(paymentMethod, that.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), paymentMethod);
    }
}
