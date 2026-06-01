package k23cnt2.nhom4.prj4.ttcd.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductCreateDTO {

    private String name;

    private String slug;

    private String description;

    private String imageUrl;

    private BigDecimal basePrice;

    private Integer categoryId;

    private List<Integer> variantIds;

    private List<Integer> optionIds;
}