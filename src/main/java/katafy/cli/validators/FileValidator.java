package katafy.cli.validators;

import com.beust.jcommander.IValueValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;

public class FileValidator implements IValueValidator<File> {
    @Override
    public void validate(String name, File value) throws ParameterException {
        if (!value.exists()) {
            throw new ParameterException(String.format("File %s does not exist", value.getAbsolutePath()));
        } else if (value.isDirectory()) {
            throw new ParameterException(String.format("File %s is a directory, not a file", value.getAbsolutePath()));
        }
    }
}
