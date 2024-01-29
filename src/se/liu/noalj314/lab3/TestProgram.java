package se.liu.noalj314.lab3;

public class TestProgram
{
    public static void main(String[] args) {
	Stack stack = new Stack();
	Queue queue = new Queue();
	stack.push(new Person("Nisse"));
	stack.push(new Person("Heidar"));
	stack.push(new Person("Safi"));
	stack.push(new Person("Alvin"));
	stack.push(new Person("Filip"));
	while (!stack.isEmpty()) {
	    System.out.println(stack.pop());
	}

	queue.enqueue(new Person("Nisse"));
	queue.enqueue(new Person("Heidar"));
	queue.enqueue(new Person("Safi"));
	queue.enqueue(new Person("Alvin"));
	queue.enqueue(new Person("Filip"));
	while (!queue.isEmpty()) {
	    System.out.println(queue.dequeue());
	}

    }
}