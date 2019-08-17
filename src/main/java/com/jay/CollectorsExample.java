package com.jay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(CollectorsExample.class.getResourceAsStream("alphabets.txt")));
				Stream<String> stream = reader.lines();) {
			stream.map(line -> {
				String[] s = line.split(" ");
				Person p = new Person(s[0].trim(), Integer.parseInt(s[1]), s[2].trim());
				persons.add(p);
				return p;
			}).forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Stream<Person> stream = persons.stream();

		Optional<Person> opt = stream.filter(p -> p.getAge() > 0).min(Comparator.comparing(Person::getAge));

		System.out.println(opt);

		Map<Integer, Long> map = persons.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));

		System.out.println(map);

		Map<Integer, List<String>> map2 = persons.stream().collect(
				Collectors.groupingBy(Person::getAge, Collectors.mapping(Person::getName, Collectors.toList())));

		System.out.println(map2);

		Map<Integer, Set<String>> map3 = 
				persons.stream()
					.collect(Collectors.groupingBy(
							Person::getAge,
							Collectors.mapping(
									Person::getName,
									Collectors.toCollection(TreeSet::new)
								)
							)
					);

		System.out.println(map3);
		
		Map<Integer, String> map4 =
				persons.stream()
							.collect(Collectors.groupingBy(
									Person::getAge,
									Collectors.mapping(
											Person::getName,
											Collectors.joining(", ")
											)
									)
						);
				
				System.out.println(map4);
	}
}
