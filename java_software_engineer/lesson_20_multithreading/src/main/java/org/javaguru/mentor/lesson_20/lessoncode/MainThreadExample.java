package org.javaguru.mentor.lesson_20.lessoncode;

class MainThreadExample {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		System.out.println("Thread id = " + currentThread.getId());
		System.out.println("Thread name = " + currentThread.getName());
		System.out.println("Thread priority = " + currentThread.getPriority());
		System.out.println("Thread state = " + currentThread.getState());
	}

}
