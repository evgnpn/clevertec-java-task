package ru.clevertec.checksystem.core.io.write;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.clevertec.checksystem.core.entity.receipt.Receipt;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.Collection;

@Component
public class JsonReceiptWriter implements IReceiptWriter {

    private final ObjectMapper objectMapper;

    @Autowired
    public JsonReceiptWriter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public byte[] write(Collection<Receipt> receipts) throws IOException {
        return objectMapper.writeValueAsBytes(receipts);
    }

    @Override
    public void write(Collection<Receipt> receipts, OutputStream os) throws IOException {
        objectMapper.writeValue(os, receipts);
    }

    @Override
    public void write(Collection<Receipt> receipts, File destinationFile) throws IOException {
        Files.createDirectories(destinationFile.toPath().getParent());
        objectMapper.writeValue(destinationFile, receipts);
    }
}
