package br.com.ac.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Carvalho
 */
@Service
public class DataAnalysisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataAnalysisService.class);

    @Value("${app.data.directory.in}")
    private String inDirectory;

    @Value("${app.data.directory.out}")
    private String outDirectory;

    private List<String> filesDone = new ArrayList<>();

    private DataAnalysisService() {
    }

    @PostConstruct
    private void init() {
        Path inPath = Paths.get(inDirectory);
        Path outPath = Paths.get(outDirectory);

        if (!inPath.toFile().exists()) throw new RuntimeException("in directory not exists: " + inDirectory);
        if (!outPath.toFile().exists()) throw new RuntimeException("out directory not exists: " + outDirectory);

        try {
            Files.list(outPath)
                    .filter(path -> path.toString().endsWith(".done.dat"))
                    .forEach(this::done);
        } catch (IOException e) {
            LOGGER.error("Error on verify files output", e);
        }
    }

    public boolean alreadyExecuted(Path path) {
        return filesDone.contains(getNameFileDone(path));
    }

    public void done(Path path) {
        filesDone.add(path.getFileName().toString());
    }

    public String getNameFileDone(Path path) {
        String fileName = path.getFileName().toString();

        return fileName.substring(0, fileName.length() - 3) + "done.dat";
    }
}
