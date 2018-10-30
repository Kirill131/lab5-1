package thread;

class ShapeRect implements Runnable{
    Thread T;
    int x_Tri[];
    int y_Tri[];
    int x_Tri2[];
    int y_Tri2[];
    public ShapeRect(){ //конструктор
        T = new Thread(this);

        x_Tri= new int[] {200, 250, 300};
        y_Tri= new int[] {0, 250, 0};
        x_Tri2= new int[] {200, 250, 300};
        y_Tri2= new int[] {500, 560, 500};

        T.start();
    }
    public void run(){
        while(true){
            while (y_Tri[0]<250) {
             //изменение координаты треугольника
                x_Tri[0] += 2;
                x_Tri[2] -= 2;
                y_Tri[0] += 10;
                y_Tri[2] += 10;
                y_Tri2[1] -= 10;
            try{
                T.sleep(500);  //приостановка работы потока на ... миллисекунд
            }
            catch (InterruptedException e){}
        }
    }
    }
}
