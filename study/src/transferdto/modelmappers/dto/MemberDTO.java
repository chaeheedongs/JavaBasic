package transferdto.modelmappers.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberDTO {

    private Long memberId;
    private String name;
    private int age;
    private String email;
    private String cellphone;
    private String zipcode;
}
