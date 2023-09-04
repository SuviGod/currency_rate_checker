package edu.sulima.genesis.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

  public void createFile(String fileUri) {
    Path filePath = Path.of(fileUri);

    checkDirectoryExistance(filePath.getParent());

    try {
      Files.deleteIfExists(filePath);
      Files.createFile(filePath);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private void checkDirectoryExistance(Path directoryPath) {
    if(Files.notExists(directoryPath)) {
      throw new RuntimeException(
          "directory" + directoryPath.toString() + " does not exist");
    }
  }

  public void appendToFile(String textToWrite, String fileUri) {
    Path filePath = Path.of(fileUri);
    try {
      Files.write(filePath, textToWrite.getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public class LineReader implements AutoCloseable {
    private final BufferedReader bufferedReader;
    private LineReader(String fileUri){
      try {
        bufferedReader = Files.newBufferedReader(Path.of(fileUri));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    public Optional<String> readLine() {
      try {
        return Optional.ofNullable(bufferedReader.readLine());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    public void close() throws Exception {
      bufferedReader.close();
    }
  }

  public LineReader newLineReader(String fileUri) {
    return new LineReader(fileUri);
  }

  public List<String> readAllLines(String fileUri) {
    Path filePath = Path.of(fileUri);
    try {
      return Files.readAllLines(filePath);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
