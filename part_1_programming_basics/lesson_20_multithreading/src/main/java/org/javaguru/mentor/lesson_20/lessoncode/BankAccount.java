package org.javaguru.mentor.lesson_20.lessoncode;

class BankAccount {

	private int money;

	public BankAccount(int money) {
		this.money = money;
	}

	// synchronized

	public  void add(int moneyToAdd) {
		this.money = this.money + moneyToAdd;
	}

	public  void remove(int moneyToRemove) {
		this.money = this.money - moneyToRemove;
	}

	public int getMoney() {
		return money;
	}

}
