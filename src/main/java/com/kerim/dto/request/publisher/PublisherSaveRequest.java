package dev.kerim.dto.request.publisher;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherSaveRequest {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private LocalDate year;
    @NotNull
    @NotEmpty
    private String address;
}
