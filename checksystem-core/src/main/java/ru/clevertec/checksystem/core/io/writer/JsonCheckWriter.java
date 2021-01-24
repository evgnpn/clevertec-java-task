package ru.clevertec.checksystem.core.io.writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.clevertec.checksystem.core.check.Check;

import java.io.File;
import java.util.Collection;

public class JsonCheckWriter extends CheckWriter {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public byte[] write(Collection<Check> input) throws Exception {
        return mapper.writeValueAsBytes(input);
    }

    @Override
    public void write(Collection<Check> input, File file) throws Exception {
        mapper.writeValue(file, input);
    }
}
