package ru.home.statistic;

import lombok.Builder;
import lombok.Data;

import java.time.LocalTime;

@Data
@Builder
public class Statistic {

    private final LocalTime averageDurationOfRelease;
    private final Double shareOfSubmittedDeclarationsBeforeNoonByMonth;
    private final Double shareOfReleasedDeclarationsWithinOneDayByMonth;
    private final Long declarationsCountInProgress;

    public Statistic(LocalTime averageDurationOfRelease, Double shareOfSubmittedDeclarationsBeforeNoonByMonth, Double shareOfReleasedDeclarationsWithinOneDayByMonth, Long declarationsCountInProgressDouble) {
        this.averageDurationOfRelease = averageDurationOfRelease;
        this.shareOfSubmittedDeclarationsBeforeNoonByMonth = shareOfSubmittedDeclarationsBeforeNoonByMonth;
        this.shareOfReleasedDeclarationsWithinOneDayByMonth = shareOfReleasedDeclarationsWithinOneDayByMonth;
        this.declarationsCountInProgress = declarationsCountInProgressDouble;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "averageDurationOfRelease=" + averageDurationOfRelease +
                ", shareOfSubmittedDeclarationsBeforeNoonByMonth=" + shareOfSubmittedDeclarationsBeforeNoonByMonth +
                ", shareOfReleasedDeclarationsWithinOneDayByMonth=" + shareOfReleasedDeclarationsWithinOneDayByMonth +
                ", countOfeDeclarationsInProgress=" + declarationsCountInProgress +
                '}';
    }
}
