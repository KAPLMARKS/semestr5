package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserData implements Serializable {

    private String name;
    private String surname;
    private String passportNumber;
    private String age;
    private Date issueDate;
}