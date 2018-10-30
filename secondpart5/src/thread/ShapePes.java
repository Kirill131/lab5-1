package thread;

class ShapePes implements Runnable{
    Thread T;
    int x_Pes, y_Pes, w_Pes, h_Pes;
    public ShapePes(){
        T = new Thread(this);

        x_Pes = 248; y_Pes = 200; w_Pes = 5; h_Pes = 5;
        T.start();
    }
    public void run(){//метод run
        for(;;){
            y_Pes += 10;
            try{
                T.sleep(100); //приостановка работы потока на 100 миллисекунд
            }
            catch (InterruptedException e){	}
        }
    }
}