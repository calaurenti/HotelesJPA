package hotelesjpa.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
@Access(AccessType.FIELD)
public class ChannelCommission {
    @Column(name = "CHANNEL", length = 50)
    private String channel;

    @Column(name = "COMMISSION", precision = 4, scale = 4)
    private BigDecimal commission;

    public ChannelCommission() {}

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
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
        ChannelCommission that = (ChannelCommission) o;
        return Objects.equals(this.channel, that.channel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), channel);
    }
}
