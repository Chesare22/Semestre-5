public class Renta {
	private Pelicula _pelicula;
	private int _diasRentado;
	
	public Renta(Pelicula pelicula, int diasRentado){
		_pelicula = pelicula;
		_diasRentado = diasRentado;
	}

	public Pelicula get_pelicula() {
		return _pelicula;
	}

	public int get_diasRentado() {
		return _diasRentado;
	}

}
