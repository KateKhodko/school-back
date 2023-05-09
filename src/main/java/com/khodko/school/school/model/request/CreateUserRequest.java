package com.khodko.school.school.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreateUserRequest extends AbstractUserRequest {

	@NotNull
	private String name;

	@NotNull
	private String password;

	@NotNull
	private String repeatPassword;

	private String userRole;
}
