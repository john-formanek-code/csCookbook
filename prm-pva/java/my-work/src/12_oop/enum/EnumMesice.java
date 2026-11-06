package enumus;

import java.util.EnumSet;

public class EnumMesice {
    public enum Month {
        LEDEN(1, "Jan"),
        UNOR(2, "Feb"),
        BREZEN(3, "Mar"),
        DUBEN(4, "Apr"),
        KVETEN(5, "May"),
        CERVEN(6, "Jun"),
        CERVENEC(7, "Jul"),
        SRPEN(8, "Aug"),
        ZARI(9, "Sep"),
        RIJEN(10, "Oct"),
        LISTOPAD(11, "Nov"),
        PROSINEC(12, "Dec");

        private final int order;
        private final String shortText;

        private Month(int order, String shortText) {
            this.order = order;
            this.shortText = shortText;
        }

        public int getOrder() {
            return order;
        }

        public String getShortText() {
            return shortText;
        }

        public static Month getByOrder(int order) {
            for (Month m : Month.values()) {
                if (m.getOrder() == order) {
                    return m;
                }

            }
            return null;

        }

        public static void main(String[] args) {
            Month mMonth1 = Month.ZARI;
            System.out.println("m1: " + mMonth1 + " " + mMonth1.getShortText());
            Month mMonth2 = Month.getByOrder(6);
            System.out.println("m2: " + mMonth2 + " " + mMonth2.getShortText());

            EnumSet<Month> monthEnumSet = EnumSet.range(Month.LEDEN, Month.CERVEN);
            monthEnumSet.addAll(EnumSet.range(Month.CERVENEC, Month.SRPEN));

            for (Month m : Month.values()) {
                System.out.println("--> " + m);
            }

        }

    }
}
