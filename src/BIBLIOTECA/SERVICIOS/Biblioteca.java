package BIBLIOTECA.SERVICIOS;

import BIBLIOTECA.ENTIDADES.*;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Documento> documentos;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        this.documentos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    //Métodos------------
    public void addDocumento(Documento documento) {
        this.documentos.add(documento);
    }
    public void delDocumentos(Documento documento){
        this.documentos.remove(documento);
    }

    public void addUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }
    public void delUsuarios(Usuario usuario){
        this.usuarios.remove(usuario);
    }

    /**
     * Método para buscar un usuario en la lista de una biblioteca
     * @param dni comprobamos que sean iguales
     * @return al usuario si lo encuentra, si no, no devuelve nada.
     */
    private Usuario buscarUsuario(String dni){
        for (Usuario usuario : this.usuarios){
            if (usuario.getDni().equals(dni)){
                return usuario;
            }
        }
        return null;
    }

    public boolean prestaDocumento(Documento doc, String dniUsuario){
        //Llamamos al método para buscar al usuario
        Usuario usuario = buscarUsuario(dniUsuario);

        //No encontrado
        if (usuario == null){
            return false;
        } else
            
    }

}
