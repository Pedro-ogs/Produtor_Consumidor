public class Consumidor extends Thread {
    News news = new News();

    public Consumidor(News news) {
        this.news = news;
    }

    @Override
    public void run() {
        while (true){

            news.consumirNoticia(this.getName());

            try {
                sleep(3000);
            }catch (Exception e){
                System.out.print("Produtor Thread: " + this.getName() + " Erro: " + e.getMessage() +"\n");
            }
        }
    }
}
