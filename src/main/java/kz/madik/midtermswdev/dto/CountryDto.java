package kz.madik.midtermswdev.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {
    private Long idDto;

    private String codeDto;

    private String countryDto;
}
