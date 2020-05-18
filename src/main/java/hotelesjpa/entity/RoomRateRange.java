package hotelesjpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class RoomRateRange {

    @Column(name = "CURRENCY", nullable = false, length = 3)
    private String currency;

    @Column(name = "MIN_RATE", nullable = false)
    private BigDecimal minRate;

    @Column(name = "MAX_RATE", nullable = false)
    private BigDecimal maxRate;

    public RoomRateRange(){}

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getMinRate() {
        return minRate;
    }

    public void setMinRate(BigDecimal minRate) {
        this.minRate = minRate;
    }

    public BigDecimal getMaxRate() {
        return maxRate;
    }

    public void setMaxRate(BigDecimal maxRate) {
        this.maxRate = maxRate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final RoomRateRange other = (RoomRateRange) o;
        return Objects.equals(this.currency, other.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.currency);
    }

}
