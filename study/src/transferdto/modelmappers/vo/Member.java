package transferdto.modelmappers.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {

    private Long memberId;
    private String name;
    private int age;
    private String email;
    private String cellphone;
    private String zipcode;
}
