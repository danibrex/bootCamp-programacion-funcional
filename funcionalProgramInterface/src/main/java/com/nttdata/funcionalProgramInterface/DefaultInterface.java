package com.nttdata.funcionalProgramInterface;

public interface DefaultInterface {
	
	String printCustom(String string);

	
	default void print(String string) {
		System.out.println("Soy un método default de una clase interface");
	}
	
	
}
