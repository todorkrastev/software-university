package bg.manhattan.springmvc.model;

import java.time.LocalDate;
import java.time.LocalTime;

public enum AgeCalculationType {
    START_OF_YEAR {
        @Override
        public int calculateAge(LocalDate birthDate, LocalDate editionDate) {
            System.out.println(START_OF_YEAR);
            return 1;
        }
    },
    START_OF_CONTEST {
        @Override
        public int calculateAge(LocalDate birthDate, LocalDate editionDate) {
            System.out.println(START_OF_CONTEST);
            return 2;
        }
    },
    YEAR_OF_BIRTH {
        @Override
        public int calculateAge(LocalDate birthDate, LocalDate editionDate) {
            System.out.println(YEAR_OF_BIRTH);
            return 3;
        }
    };

    public abstract int calculateAge(LocalDate birthDate, LocalDate editionDate);
}
