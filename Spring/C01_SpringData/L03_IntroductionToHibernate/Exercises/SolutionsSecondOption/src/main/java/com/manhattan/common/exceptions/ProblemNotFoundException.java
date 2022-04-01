package com.manhattan.common.exceptions;

public class ProblemNotFoundException extends Throwable {
    int problemNumber;
    public ProblemNotFoundException(int problemNumber) {
        this.problemNumber = problemNumber;
    }

    @Override
    public String getMessage(){
        return String.format("Problem %d doesn't exist!%n", this.problemNumber);
    }
}
