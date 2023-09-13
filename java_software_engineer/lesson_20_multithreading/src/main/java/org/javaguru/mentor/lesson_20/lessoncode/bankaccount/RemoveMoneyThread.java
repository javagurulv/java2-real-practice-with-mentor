package org.javaguru.mentor.lesson_20.lessoncode.bankaccount;

class RemoveMoneyThread implements Runnable {

	private BankAccount bankAccount;

	public RemoveMoneyThread(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000000; i++) {
			bankAccount.remove(1);
		}
	}
}
