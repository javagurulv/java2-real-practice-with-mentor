package org.javaguru.mentor.lesson_20.lessoncode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class StreamApiMultiThreading {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		List<String> result = list.stream().parallel()
				.filter(s -> s.equals("ABC"))
				.collect(Collectors.toList());

	}

}