package com.jay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import ch.qos.logback.classic.net.SyslogAppender;

public class StreamsExample {

	public static void main(String[] args) {

//		List<Person> persons = new ArrayList<Person>();
		Person p1 = new Person();
		p1.setAge(11);
		p1.setSex("M");
		p1.setName("P1");
		Person p2 = new Person();
		p2.setAge(22);
		p2.setSex("M");
		p2.setName("P2");
		List<Person> persons = Arrays.asList(p1,p2);
		Stream<Person> personStream = persons.stream();
		
		Stream<Person> personFiltered = personStream.filter(person -> person.getAge() > 20 );
		
		//personStream.forEach(p -> System.out.println(p.toString()));
		personFiltered.forEach(p -> System.out.println(p.toString()));
		
		
		Stream<String> stringStream = Stream.of("one","two","three","four","five");
		
		Predicate<String> pr1 = Predicate.isEqual("two");
		Predicate<String> pr2 = Predicate.isEqual("three");
		
		List<String> list = new ArrayList<>();

		stringStream
				.peek(System.out::println)
				.filter(pr1.or(pr2))
				.peek(list::add)
				.forEach(System.out::println);

		//stringStream.forEach(System.out::println);
		
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(2,4,6);
		List<Integer> list3 = Arrays.asList(3,5,7);
		
		List<List<Integer>> listOfLists = Arrays.asList(list1,list2,list3);
		
		Function<List<?>, Integer> size = List::size;
		Function<List<Integer>, Stream<Integer>> flatMapper = l -> l.stream();
		
		listOfLists.stream()
					//.map(l->l.size())
					//.map(size)
					//.map(flatMapper)
					.flatMap(flatMapper)
					.forEach(System.out::println);
		
		
		Stream<Integer> intEmptyStream = Stream.empty();
		int red = intEmptyStream.reduce(0, (i1, i2) -> i1+i2);
		System.out.println(red);
		
		Stream<Integer> intStream = Stream.of(1);
		red = intStream.reduce(0, (i1, i2) -> i1+i2);
		System.out.println(red);
		
		Stream<Integer> intMultiStream = Stream.of(2,3,4,5,1,2,3);
		red = intMultiStream.reduce(0, (i1, i2) -> i1+i2);
		System.out.println(red);
		
	}

}
