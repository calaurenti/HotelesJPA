package hotelesjpa.entity.type;

public enum MealPlan {
    ALL_INCLUSIVE(1),
    AMERICAN_BREAKFAST(2),
    BUFFET_BREAKFAST(4),
    CONTINENTAL_BREAKFAST(6),
    FULL_BOARD(10),
    HALF_BOARD_AMERICAN_PLAN(12),
    ROOM_ONLY(14),
    DINNER_AND_BREAKFAST(17),
    BREAKFAST(19),
    BREAKFAST_AND_LUNCH(23);

    private int code;

    private MealPlan(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
