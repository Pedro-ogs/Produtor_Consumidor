public class Produtor extends Thread{

    private News news;
    int count = 0;

    public Produtor(News news) {
        this.news = news;
    }

    @Override
    public void run() {
        while (true){

            count++;
            String noticia = "Produzindo a noticia Nº: " + count;
            news.produzirNoticia(noticia, this.getName());

            try {
                sleep(1500);
            }catch (Exception e){
                System.out.print("Produtor Thread: " + this.getName() + " Erro: " + e.getMessage() +"\n");
            }
        }
    }
}
