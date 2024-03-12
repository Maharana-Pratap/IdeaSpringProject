package com.example.cloudstream;

import java.util.function.function;

@springbootapplication
public class cloudstreamapplication {

	public static void main(string[] args) {
		springapplication.run(cloudstreamapplication.class, args);
	}

	@bean
	public function<string,string> touppercaseres() {
		return (data) -> data.touppercase();
	}
}
