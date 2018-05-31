package br.com.ac.processor;

import br.com.ac.model.DataAnalysisSummarized;
import br.com.ac.service.DataAnalysisService;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Alex Carvalho
 */
public class FileProcessorJob extends QuartzJobBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileProcessorJob.class);

    @Value("${app.data.directory.in}")
    private String inDirectory;

    @Value("${app.data.directory.out}")
    private String outDirectory;

    @Autowired
    private DataAnalysisService service;

    @Autowired
    private DataAnalysisProcessor analysisProcessor;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        try {
            Path inPath = Paths.get(inDirectory);

            LOGGER.info("Checking new files...");

            Files.list(inPath)
                    .filter(path -> path.toString().endsWith(".dat") && !service.alreadyExecuted(path))
                    .forEach(this::processFile);

        } catch (Exception e) {
            LOGGER.error("Error on checking new files", e);
        }
    }

    private void processFile(Path path) {
        LOGGER.info("Processing file: " + path.getFileName());
        try {
            DataAnalysisSummarized dataAnalysisSummarized = analysisProcessor.processFile(path);

            String fileName = service.getNameFileDone(path);

            Path outPath = Paths.get(outDirectory, fileName);

            Files.write(outPath, dataAnalysisSummarized.getSummarized());

            service.done(outPath);

            LOGGER.info("Processing file: " + path.getFileName() + " - done!");
        } catch (Exception e) {
            LOGGER.error("Error on process file: " + path.getFileName(), e);
        }
    }
}
