package com.ily.springMvcProject.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class UserService {
	@Value("ilyass")
	private String name;
}
