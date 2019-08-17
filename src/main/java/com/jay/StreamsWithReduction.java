package com.jay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsWithReduction {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		Integer reduce = list.stream()
		.reduce(0, (i1,i2)-> i1+i2);

		System.out.println(reduce);
		
		List<Integer> ages = Arrays.asList(2,3,4,5,6,31);
		Stream<Integer> stream = ages.stream();
		System.out.println(stream.max(Comparator.naturalOrder()));
		Stream<Integer> emptyStream = Stream.empty();
		System.out.println(emptyStream.max(Comparator.naturalOrder()));
		
		stream = list.stream();
		Optional<Integer> opt = stream.max(Comparator.naturalOrder());
		if(opt.isPresent()) {
			System.out.println(opt.get());
		}

		Optional<Integer> red = 
		list.stream()
				.reduce(Integer::max);
//		.max(Comparator.naturalOrder());
		
		System.out.println(red);
				
	}

}
