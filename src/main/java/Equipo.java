public class Equipo {

    private Trabajador lider;

    private Trabajador[] participantes = new Trabajador[8];

    private int numParticipantes = 0;

    public int getMaxNumeroParticipantes() {
        return Ctes.MAX_NUM_PARTICIPANTES_EQUIPO;
    }

    public Trabajador getParticipante(int numero) {
        if (numero > 0 && numero <= participantes.length) {
            return participantes[numero - 1];
        }
        return null;
    }

    public void setParticipante(int numero, Trabajador trabajador) {
        if (numero > 0 && numero <= participantes.length) {
            participantes[numero - 1] = trabajador;
        }
    }

    public boolean tieneLider() {
        // TODO 21: Saber si el equipo tiene líder
        if (lider != null) {
            return true;
        } else {
            return false;
        }
    }

    public Trabajador getLider() {
        // TODO 22: Devolver quién es el líder
        return lider;
    }

    public void setLider(int numeroParticipante) {
        // TODO 23: Asignar el liderazgo a un participante
        lider = getParticipante(numeroParticipante);
    }

    public int getNumeroParticipantes() {
        // TODO 24: Calcular el número de participantes utilizando un bucle
        int num = 0;
        for (int i = 0; i < participantes.length; i++) {
            if (participantes[i] != null) {
                num++;
            }
        }
        return num;
    }

    public boolean estaEquipoCompleto() {
        return getNumeroParticipantes() == getMaxNumeroParticipantes();
    }

    public boolean addParticipante(Trabajador trabajador) {
        // TODO 25: Agregar un trabajador como participante si no se ha llegado al límite utilizando un bucle
        if (!estaEquipoCompleto()) {
            for (int i = 0; i < participantes.length; i++) {
                if (participantes[i] == null) {
                    setParticipante(i, trabajador);
                }
            }
        }
        return false;
    }

    public void mostrar() {
        // TODO 26: Mostrar los participantes del equipo junto con su número de participante utilizando un bucle
        for (int i = 0; i < participantes.length; i++) {
            System.out.println(getParticipante(i) + " " + i + "\n");
        }
    }

    public int getPrecioHora() {
        int precio = 0;
        // TODO 27: Calcular el precio de la hora de todos los participantes del equipo utilizando un bucle
        for (int i = 0; i < participantes.length; i++) {
            precio += participantes[i].getPrecioHora();
        }
        return precio;
    }
}
