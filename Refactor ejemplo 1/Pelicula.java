
public class Pelicula {
	public static final int NINIOS = 2;
	public static final int NORMALES = 0;
	public static final int ESTRENOS = 1;
	
	public String _titulo;
	public int _precio;
	
	public Pelicula (String titulo, int precio) {
		_titulo = titulo;
		_precio = precio;
	}

	public int get_precio() {
		return _precio;
	}

	public void set_precio(int _precio) {
		this._precio = _precio;
	}

	public String get_titulo() {
		return _titulo;
	}

}
