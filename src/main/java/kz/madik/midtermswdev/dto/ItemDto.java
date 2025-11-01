package kz.madik.midtermswdev.dto;


import kz.madik.midtermswdev.entity.Category;
import kz.madik.midtermswdev.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long idDto;

    private String nameDto;

    private String descriptionDto;

    private int priceDto;

    private Category categoryDto;

    private List<Country> countriesDto;
}
