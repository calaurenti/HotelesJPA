package hotelesjpa.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class BedLayout {

    @Column(name = "CODE", length = 20, nullable = false)
    private String code;

    @Column(name = "BED_COUNT", nullable = false)
    private Short count;

    public BedLayout(){};

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Short getCount() {
        return count;
    }

    public void setCount(Short count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final BedLayout other = (BedLayout) o;
        return Objects.equals(this.code, other.code)
                && Objects.equals(this.count, other.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code);
    }
}
