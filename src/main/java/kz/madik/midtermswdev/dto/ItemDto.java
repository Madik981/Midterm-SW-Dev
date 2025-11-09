package kz.madik.midtermswdev.dto;


import kz.madik.midtermswdev.entity.Category;
import kz.madik.midtermswdev.entity.Country;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {
    private Long idDto;

    private String nameDto;

    private String descriptionDto;

    private int priceDto;

    private Category categoryDto;

    private List<Country> countriesDto;
}
