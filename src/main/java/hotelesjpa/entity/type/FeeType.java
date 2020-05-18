package hotelesjpa.entity.type;

public enum FeeType {
    /**
     * The gain will be added to the cost to get the final price before taxes
     */
    MARKUP,

    /**
     * Represents the maximum gain Despegar.com will obtain over the commissionable price without affecting the hotel
     * cost The gain will be obtained from subtracting the hotel cost to the commissionable price
     */
    COMMISSIONABLE
}
