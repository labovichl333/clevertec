package by.clevertec.testTask.output.impl;

import by.clevertec.testTask.exeption.OutputException;
import by.clevertec.testTask.output.CheckOutput;

import java.io.FileWriter;
import java.io.IOException;

public class FileCheckOutput implements CheckOutput {
    private String fileName;

    public FileCheckOutput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void output(String check) throws OutputException {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(check);
            writer.flush();
        } catch (IOException e) {
            throw new OutputException(e);
        }
    }
}
