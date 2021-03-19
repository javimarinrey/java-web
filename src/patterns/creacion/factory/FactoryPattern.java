package patterns.creacion.factory;

public class FactoryPattern {

    public static void main(String[] args){
        CreadorAbstracto creator = new Creador();

        IArchivo audio = creator.crear(Creador.AUDIO);
        audio.reproducir();

        IArchivo video = creator.crear(Creador.VIDEO);
        video.reproducir();
    }

}
