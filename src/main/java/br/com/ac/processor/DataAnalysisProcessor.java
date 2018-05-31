package br.com.ac.processor;

import br.com.ac.domain.DataType;
import br.com.ac.model.Customer;
import br.com.ac.model.DataAnalysisSummarized;
import br.com.ac.model.Model;
import br.com.ac.model.Sale;
import br.com.ac.model.Salesman;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Alex Carvalho
 */
@Service
public class DataAnalysisProcessor {

    private DataAnalysisProcessor() {
    }

    /**
     * Process file and return summarized analysis
     *
     * @param path
     * @return
     * @throws IOException
     */
    public DataAnalysisSummarized processFile(Path path) throws IOException {
        Map<Class, List<Model>> modelsMap = Files.lines(path)
                .filter(line -> line != null && !line.trim().isEmpty())
                .map(this::parseLineToModel)
                .collect(Collectors.groupingBy(Model::getClass));

        List<Model> customers = modelsMap.get(Customer.class);
        List<Model> salesman = modelsMap.get(Salesman.class);
        List<Model> sales = modelsMap.get(Sale.class);

        Integer amountClients = customers != null ? customers.size() : 0;
        Integer amountSalesman = salesman != null ? salesman.size() : 0;
        Sale expensiveSale = sales != null ? mostExpensiveSale(sales) : null;
        Salesman worstSalesman = (salesman != null && sales != null) ? worstSalesman(salesman, sales) : null;

        return DataAnalysisSummarized.of(amountClients, amountSalesman, expensiveSale, worstSalesman);
    }

    /**
     * Process line and return model object
     *
     * @param line
     * @return
     */
    private Model parseLineToModel(String line) {
        String type = line.substring(0, 3);
        String data = line.substring(4);

        return DataType.of(type)
                .getParser()
                .parse(data);
    }

    /**
     * verify which salesman sold less
     *
     * @param salesmans
     * @param sales
     * @return
     */
    private Salesman worstSalesman(List<Model> salesmans, List<Model> sales) {
        Map<String, Double> collect = sales.stream()
                .map(model -> (Sale) model)
                .collect(Collectors.groupingBy(Sale::getSalesmanName, Collectors.summingDouble(sale -> sale.getTotal().doubleValue())));

        String name = collect.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .get()
                .getKey();

        return salesmans.stream()
                .map(model -> (Salesman) model)
                .filter(model -> model.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Salesman '" + name + "' not found!"));
    }

    private Sale mostExpensiveSale(List<Model> sales) {
        return sales.stream()
                .map(model -> (Sale) model)
                .max(Comparator.comparing(Sale::getTotal))
                .get();
    }

}
