package org.javaguru.math.operation;

class Addition extends TwoArgumentMathOperation {

	public Addition(MathOperation leftArgument,
					MathOperation rightArgument) {
		super(leftArgument, rightArgument);
	}

	@Override
	public double calculate() {
		return calculateLeftSide() + calculateRightSide();
	}
}
