public class News {

    private int maxNumberNews = 10;
    private StringBuffer[] news;
    private int count = 0;
    private int inNews = 0;
    private int outNews = 0;


    public News() {
        this.news = new StringBuffer[maxNumberNews];
    }

    public synchronized void consumirNoticia(String name){
        while (this.count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Não foi possivel fazer a Thread esperar: " + name);
                System.out.println(e.getMessage());
            }
        }

        System.out.println("O consumidor: " + name + " Consumiu a noticia: " + outNews);
        this.news[outNews] = null;
        count--;

        outNews++;
        if (outNews == maxNumberNews){
            outNews = 0;
        }

        notifyAll();
    }

    public synchronized void produzirNoticia(String noticia, String name){
        while (this.count == maxNumberNews){
            try {
                this.wait();
            } catch (InterruptedException e) {
                System.out.println("Não foi possivel fazer a Thread esperar: " + name);
                System.out.println(e.getMessage());
            }
        }

        this.news[inNews] = new StringBuffer(noticia);
        System.out.println("O Produtor: "+ name+ " produziu a noticia: "+ inNews);
        count++;

        inNews++;
        if (inNews == maxNumberNews){
            inNews = 0;
        }

        notifyAll();
    }
}
