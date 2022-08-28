package Java8;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ReduceFunction {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers).reduce(0, Integer::sum);
        int sum1 = Arrays.stream(numbers).reduce(0, (a, b) -> a - b);
        int min = Arrays.stream(numbers).reduce(0, Math::min);
        System.out.println(sum);
        System.out.println(sum1);

        List<Invoice> invoices = Arrays.asList(
                new Invoice("I1001", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
                new Invoice("I1002", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
                new Invoice("I1003", BigDecimal.valueOf(4.888), BigDecimal.valueOf(2)),
                new Invoice("I1004", BigDecimal.valueOf(4.99), BigDecimal.valueOf(5)),
                new Invoice("I1005", BigDecimal.valueOf(.5), BigDecimal.valueOf(2.3))
        );

        BigDecimal sum12 = invoices.stream()
                .map(x -> x.getQty().multiply(x.getPrice()))    // map
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(sum);    // 75.851
        //System.out.println(sum.setScale(2, RoundingMode.HALF_UP));
    }
    static class Invoice {

        String invoiceNo;
        BigDecimal price;
        BigDecimal qty;

        public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
            this.invoiceNo = invoiceNo;
            this.price = price;
            this.qty = qty;
        }

        public String getInvoiceNo() {
            return invoiceNo;
        }

        public void setInvoiceNo(String invoiceNo) {
            this.invoiceNo = invoiceNo;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getQty() {
            return qty;
        }

        public void setQty(BigDecimal qty) {
            this.qty = qty;
        }
    }

}

