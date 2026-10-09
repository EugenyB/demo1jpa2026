package ua.edu.nuos.demo1jpa.data;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link Teacher}
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDto implements Serializable {
    private Integer id;
    private String name;
    private int experience;
}