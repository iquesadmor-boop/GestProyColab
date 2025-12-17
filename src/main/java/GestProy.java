public class GestProy {

    private static Proyecto[] proyectos = {
            new Proyecto("Proyecto 1", 1000),
            new Proyecto("Proyecto 2", 1540),
            new Proyecto("Proyecto 3", 1320),
            new Proyecto("Proyecto 4", 1230)
    };


    // getters y setters
    public Proyecto getProyecto(int numero) {
        switch (numero){
            case 1: return proyectos[1];
            case 2: return proyectos[2];
            case 3: return proyectos[3];
            case 4: return proyectos[4];
        }
        return null;
    }

    public void setProyecto(int numero, Proyecto proyecto) {
        switch (numero){
            case 1: proyectos[1] = proyecto; break;
            case 2: proyectos[2] = proyecto; break;
            case 3: proyectos[3] = proyecto; break;
            case 4: proyectos[4] = proyecto; break;
        }
    }
    // endregion

    public void terminarProyecto(int numProyecto) {
        // TODO 31: Terminar proyecto

    }

    public boolean puedeHaberMasProyectos() {
        return getCantidadProyectosActivos() < Ctes.MAX_NUM_PROYECTOS_GESTOR;
    }

    public int getMaxNumProyectos() {
        return Ctes.MAX_NUM_PROYECTOS_GESTOR;
    }

    public int getCantidadProyectosActivos() {
        // TODO 32: Contar el número de proyectos activos utilizando un bucle
        int n = 0;
        for (int i = 0; i < proyectos.length; i++) {
            if (proyectos[i] != null){
                n ++;
            }
        }
        return n;
    }

    public boolean addHorasProyecto(String nombreProyecto, int numeroHoras) {
        // TODO 33: Añadir horas al número de proyecto indicado
        // Si el proyecto no existe devolver false, sino true tras asignar las horas
        for (int i = 0; i < proyectos.length; i++) {
            if(proyectos[i].getNombre().equalsIgnoreCase(nombreProyecto)){
                proyectos[i].setHoras(numeroHoras);
                return true;
            }
        }
        return false;
    }

    public int addProyectoNuevo(String nombreProyecto, int presupuesto) {
        // TODO 34: Agregar el proyecto si hay hueco utilizando un bucle
        for (int i = 0; i < proyectos.length; i++) {
            if (proyectos[i] == null){
                proyectos[i] = new Proyecto(nombreProyecto,presupuesto);
                return i;
            }
        }
        return 0;
    }

    public boolean addParticipanteProyecto(int numProyecto, int numTrabajador) {
        // TODO 35: Añadir al proyecto el participante validando que el proyecto y el trabajador existe
        // si el trababajador o proyecto no existe devolver false
        // si el proyecto y el trabajador existen pero no admiten más trabajadores devolver false
        if (numProyecto < 1 || numProyecto > 10){
            return false;
        }
        Proyecto p = proyectos[numProyecto - 1];
        if (p == null){
            return false;
        }
        p.addParticipante(Trabajadores.getTrabajador(numTrabajador));
        return true;
    }

    public void mostrarProyectos() {
        // TODO 36: Mostrar los proyectos junto con su número de proyecto utilizando un bucle
        for (int i = 0; i < proyectos.length; i++) {
            System.out.print(i);
            System.out.print(proyectos[i].toString());
        }






    }

    public void mostrarEquipoProyecto(int numProyecto) {
        // TODO 37: Mostrar el equipo si existe
        if (proyectos[numProyecto - 1] != null){
                proyectos[numProyecto - 1].mostrarEquipo();
        }
    }

    public void setLiderProyecto(int numProyecto, int numParticipante) {
        Proyecto proyecto = getProyecto(numProyecto);
        if (proyecto == null) {
            return;
        }
        proyecto.setLider(numParticipante);
    }

    public void mostrarTrabajadoresEmpresa() {
        Trabajadores.mostrar();
    }

}
