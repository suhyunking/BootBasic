package com.simple.basic.command;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class BuilderVO2 {
	
	private String name;
	private int age;
}
