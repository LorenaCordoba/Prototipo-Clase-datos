/**
 * Representa un libro en la biblioteca.
 */
public class Libro {
    private String titulo;
    private String autor;
    private int id;

    /**
     * Constructor para la clase Libro.
     * @param titulo el título del libro.
     * @param autor el autor del libro.
     * @param id el identificador único del libro.
     */
    public Libro(String titulo, String autor, int id) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
    }

    /**
     * Obtiene el título del libro.
     * @return el título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     * @return el autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene el identificador único del libro.
     * @return el identificador único del libro.
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Título: " + titulo + ", Autor: " + autor;
    }
}
/**
 * Representa un usuario de la biblioteca.
 */
public class Usuario {
    private String nombre;
    private int id;

    /**
     * Constructor para la clase Usuario.
     * @param nombre el nombre del usuario.
     * @param id el identificador único del usuario.
     */
    public Usuario(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return el nombre del usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el identificador único del usuario.
     * @return el identificador único del usuario.
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre;
    }
}
/**
 * Representa un nodo en una estructura de datos enlazada.
 */
class Nodo<T> {
    T dato;
    Nodo<T> siguiente;

    /**
     * Constructor para la clase Nodo.
     * @param dato el dato almacenado en el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
/**
 * Representa una lista enlazada.
 */
class ListaEnlazada<T> {
    private Nodo<T> cabeza;

    /**
     * Constructor para la clase ListaEnlazada.
     */
    public ListaEnlazada() {
        this.cabeza = null;
    }

    /**
     * Inserta un dato al inicio de la lista.
     * @param dato el dato a insertar.
     */
    public void insertarAlInicio(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    /**
     * Busca un dato en la lista por su ID.
     * @param id el ID del dato a buscar.
     * @return el dato encontrado, o null si no se encuentra.
     */
    public T buscar(int id) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato instanceof Libro) {
                Libro libro = (Libro) actual.dato;
                if (libro.getId() == id) {
                    return actual.dato;
                }
            } else if (actual.dato instanceof Usuario) {
                Usuario usuario = (Usuario) actual.dato;
                if (usuario.getId() == id) {
                    return actual.dato;
                }
            }
            actual = actual.siguiente;
        }
        return null;
    }

    /**
     * Imprime los datos de la lista.
     */
    public void imprimir() {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
/**
 * Representa una cola.
 */
class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;

    /**
     * Constructor para la clase Cola.
     */
    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    /**
     * Verifica si la cola está vacía.
     * @return true si la cola está vacía, false de lo contrario.
     */
    public boolean estaVacia() {
        return frente == null;
    }

    /**
     * Encola un dato.
     * @param dato el dato a encolar.
     */
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
        }
        fin = nuevoNodo;
    }

    /**
     * Desencola un dato.
     * @return el dato desencolado, o null si la cola está vacía.
     */
    public T desencolar() {
        if (estaVacia()) {
            return null;
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return dato;
    }
}
/**
 * Representa una biblioteca.
 */
public class Biblioteca {
    private ListaEnlazada<Libro> libros;
    private ListaEnlazada<Usuario> usuarios;
    private Cola<Libro> librosPrestados;

    /**
     * Constructor para la clase Biblioteca.
     */
    public Biblioteca() {
        this.libros = new ListaEnlazada<>();
        this.usuarios = new ListaEnlazada<>();
        this.librosPrestados = new Cola<>();
    }

    /**
     * Agrega un libro a la biblioteca.
     * @param titulo el título del libro.
     * @param autor el autor del libro.
     * @param id el identificador único del libro.
     */
    public void agregarLibro(String titulo, String autor, int id) {
        Libro nuevoLibro = new Libro(titulo, autor, id);
        libros.insertarAlInicio(nuevoLibro);
    }

    /**
     * Agrega un usuario a la biblioteca.
     * @param nombre el nombre del usuario.
     * @param id el identificador único del usuario.
     */
    public void agregarUsuario(String nombre, int id) {
        Usuario nuevoUsuario = new Usuario(nombre, id);
        usuarios.insertarAlInicio(nuevoUsuario);
    }

    /**
     * Presta un libro de la biblioteca.
     * @param idLibro el identificador único del libro a prestar.
     * @return true si el libro se prestó correctamente, false de lo contrario.
     */
    public boolean prestarLibro(int idLibro) {
        Libro libroPrestado = libros.buscar(idLibro);
        if (libroPrestado != null) {
            librosPrestados.encolar(libroPrestado);
            return true;
        }
        return false;
    }

    /**
     * Devuelve un libro a la biblioteca.
     * @param idLibro el identificador único del libro a devolver.
     * @return true si el libro se devolvió correctamente, false de lo contrario.
     */
    public boolean devolverLibro(int idLibro) {
        Libro libroDevuelto = librosPrestados.desencolar();
        return libroDevuelto != null && libroDevuelto.getId() == idLibro;
    }

    /**
     * Muestra la lista de libros en la biblioteca.
     */
    public void mostrarLibros() {
        System.out.println("----- Libros en la Biblioteca -----");
        libros.imprimir();
    }

    /**
     * Muestra la lista de usuarios en la biblioteca.
     */
    public void mostrarUsuarios() {
        System.out.println("----- Usuarios en la Biblioteca -----");
        usuarios.imprimir();
    }
}
