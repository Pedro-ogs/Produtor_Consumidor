public class Main {
    public static void main(String[] args) {
        int producer_quant = 10;
        int consumer_quant = 1;

        News news = new News();

        for (int i = 0; i < producer_quant; i++) {
            Produtor producer = new Produtor(news);
            producer.start();
        }

        for (int i = 0; i < consumer_quant; i++) {
            Consumidor consumer = new Consumidor(news);
            consumer.start();
        }
    }
}