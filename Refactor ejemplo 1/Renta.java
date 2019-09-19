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

	public double monto() {
		return get_pelicula().monto(_diasRentado);
	}

	public int puntosRentaFrecuente() {
		int puntosRentaFrecuente = 1;
		if ((get_pelicula().get_precio() == Pelicula.ESTRENOS) && get_diasRentado() > 1)
			puntosRentaFrecuente++;

		return puntosRentaFrecuente;
	}

}
