package src.Main.Q3_06_Animal_Shelter;

//An Animal shelter which holds only dogs and cats operates on a strictly first in and first out bases.
//People must adopt either the "oldest" of all animals at the shelter or they can select whether they work prefer a dog or a cat.
//They cannot select which specific animal they would like. Create the data structures to maintain this system.
public class Solution {


	public static void main(String[] args) {
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("Billie"));
		animals.enqueue(new Cat("Chillie"));
		animals.enqueue(new Dog("Frodo"));
		animals.enqueue(new Dog("Drodo"));
		animals.enqueue(new Cat("Milli"));
		animals.enqueue(new Dog("Boxer"));
		animals.enqueue(new Dog("Beagle"));
		animals.enqueue(new Cat("Sushi"));

		System.out.println("Dequeue Dog is " + animals.dequeueDogs().name);
		System.out.println("Dequeue Cat is " + animals.dequeueCats().name);

		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dog("Dada"));
		animals.enqueue(new Cat("Milo"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}
	}

}
