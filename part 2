/**
 * Clase que representa un libro en la biblioteca.
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
 * Clase que representa un usuario de la biblioteca.
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
 * Clase que representa un nodo en una estructura de datos enlazada.
 */
class Nodo<T> {
    T dato;
    Nodo<T> izquierdo;
    Nodo<T> derecho;

    /**
     * Constructor para la clase Nodo.
     * @param dato el dato almacenado en el nodo.
     */
    public Nodo(T dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

/**
 * Clase que representa un árbol binario de búsqueda.
 * @param <T> el tipo de datos que almacenará el árbol.
 */
class ArbolBinarioBusqueda<T extends Comparable<T>> {
    private Nodo<T> raiz;

    /**
     * Constructor para la clase ArbolBinarioBusqueda.
     */
    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }

    /**
     * Inserta un dato en el árbol.
     * @param dato el dato a insertar.
     */
    public void insertar(T dato) {
        raiz = insertarRecursivo(raiz, dato);
    }

    // Implementación de los métodos privados...

}

/**
 * Clase que representa una biblioteca.
 */
public class Biblioteca {
    private ArbolBinarioBusqueda<Libro> arbolLibros;
    private ArbolBinarioBusqueda<Usuario> arbolUsuarios;
    private Queue<Libro> librosPrestados;

    /**
     * Constructor para la clase Biblioteca.
     */
    public Biblioteca() {
        this.arbolLibros = new ArbolBinarioBusqueda<>();
        this.arbolUsuarios = new ArbolBinarioBusqueda<>();
        this.librosPrestados = new LinkedList<>();
    }

    /**
     * Agrega un libro a la biblioteca.
     * @param titulo el título del libro.
     * @param autor el autor del libro.
     * @param id el identificador único del libro.
     */
    public void agregarLibro(String titulo, String autor, int id) {
        Libro nuevoLibro = new Libro(titulo, autor, id);
        arbolLibros.insertar(nuevoLibro);
    }

    // Resto de métodos...

    /**
     * Muestra la lista de libros en la biblioteca.
     */
    public void mostrarLibros() {
        System.out.println("----- Libros en la Biblioteca -----");
        inOrderTraversal(arbolLibros);
    }

    // Resto de métodos...

    // Métodos privados y auxiliares...
}
