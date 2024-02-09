package roomescape.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import roomescape.configuration.ValidateDateFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreateReservationRequest {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";

    @NotNull(message = "예약 날짜를 입력해주세요.")
    @ValidateDateFormat(message = "날짜 형식이 올바르지 않습니다.", pattern = DATE_FORMAT_PATTERN)
    private String date;

    @NotBlank(message = "예약자 이름을 입력해주세요.")
    private String name;

    @NotNull(message = "예약 시간을 입력해주세요.")
    @JsonProperty("time")
    private Long timeId;

    public CreateReservationRequest(final String date, final String name, final Long timeId) {
        this.date = date;
        this.name = name;
        this.timeId = timeId;
    }

    public LocalDate getDate() {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(DATE_FORMAT_PATTERN));
    }

    public String getName() {
        return name;
    }

    public Long getTimeId() {
        return timeId;
    }
}
