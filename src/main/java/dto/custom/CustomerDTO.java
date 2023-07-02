package dto.custom;

import dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO implements SuperDto {
    private int id;
    private String name;
    private String contact;
    private String address;
    private String gmail;
    private String gender;
}
