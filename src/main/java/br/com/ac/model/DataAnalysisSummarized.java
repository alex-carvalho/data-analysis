package br.com.ac.model;

/**
 * @author Alex Carvalho
 */
public class DataAnalysisSummarized {

    private final Integer amountClients;
    private final Integer amountSalesman;
    private final Sale expensiveSale;
    private final Salesman worstSalesman;

    private DataAnalysisSummarized(Integer amountClients, Integer amountSalesman, Sale expensiveSale, Salesman worstSalesman) {
        this.amountClients = amountClients;
        this.amountSalesman = amountSalesman;
        this.expensiveSale = expensiveSale;
        this.worstSalesman = worstSalesman;
    }

    public static DataAnalysisSummarized of(Integer amountClients, Integer amountSalesman, Sale expensiveSale, Salesman worstSalesman) {
        return new DataAnalysisSummarized(amountClients, amountSalesman, expensiveSale, worstSalesman);
    }

    public byte[] getSummarized() {
        return ("Amount of clients: " + amountClients + "\n" +
                "Amount of salesman: " + amountSalesman + "\n" +
                "ID of the most expensive sale: " + getSaleId() + "\n" +
                "Worst salesman: " + getSalesmanName()).getBytes();
    }

    private Object getSaleId() {
        return expensiveSale != null ? expensiveSale.getId().getValue() : "n/d";
    }

    private String getSalesmanName() {
        return worstSalesman != null ? worstSalesman.getName() : "n/d";
    }
}
