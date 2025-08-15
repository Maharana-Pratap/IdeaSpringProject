package com.example.demo_swager_3.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Emp information dto")
public class EmpDTO {
  @Schema(description = "unique identifier of emp" , example = "1")
  private Integer id;
  @Schema(description = "Emp Name" , example = "Ram")
  private String name;
}
