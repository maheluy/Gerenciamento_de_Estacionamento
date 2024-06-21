public class Main {

    public static void main(String[] args) {
        int i;
        Carro c = new Carro();
        Moto m = new Moto();
        Caminhao cm = new Caminhao();
        for (i = 0; i < 10; i++){
            Vaga.estacionamento.add(new Vaga(i, 1, 0, c));
        }
        for (i = 0; i < 10; i++){
            Vaga.estacionamento.add(new Vaga(i, 2, 0, m));
        }
        for (i = 0; i < 10; i++){
            Vaga.estacionamento.add(new Vaga(i, 3, 0, cm));
        }
        GUI gui = new GUI();
    }
}