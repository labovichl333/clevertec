package by.clevertec.testTask.output.impl;

import by.clevertec.testTask.output.CheckOutput;

public class ConsoleCheckOutput implements CheckOutput {
    @Override
    public void output(String check) {
        System.out.println(check);
    }
}
