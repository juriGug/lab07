package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    
    private enum Month{
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);
    
        private Month(int days){
            this.days = days;
        }
    
        final private int days;
    
        public int getDays(){
            return this.days;
        }
        public static  Month fromString(final String month){
            int counter = 0;
            Month m = null;
            for(final Month s : Month.values() ){
                if(s.toString().startsWith(month.toUpperCase())){
                    counter++;
                    m = s;
                }
            }
            if(counter == 1){
                return m;
            }
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new sortByDays();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new sortByOrder();
    }

    
    private static class sortByDays implements Comparator<String>{
        @Override
        public int compare ( String m1 , String m2 ) { 
            final var o1 = Month.fromString(m1);
            final var o2 = Month.fromString(m2);
            return Integer.compare(o1.getDays(), o2.getDays());
        }
    }

    
    private static class sortByOrder implements Comparator<String>{
        @Override
        public int compare ( String m1 , String m2 ) { 
            final var o1 = Month.fromString(m1);
            final var o2 = Month.fromString(m2);
            return o1.compareTo(o2);
        }
    }
}