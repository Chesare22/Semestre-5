import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;


public class Cliente {
	private String _nombre;
	private ArrayList<Renta> _rentas = new ArrayList<Renta>();
	
	public Cliente (String nombre){
		_nombre = nombre;
	}
	
	public void addRenta(Renta renta){
		_rentas.add(renta);
	}
	
	public String getNombre(){
		return _nombre;
	}
	public String realizarRenta(){
		double montoTotal = 0;
		int puntosRentaFrecuente = 0;
		Enumeration<Renta> rentas = (Enumeration<Renta>) Collections.enumeration(_rentas);
		String resultado = " Registro de rentas de " + getNombre() + "\n";
		while(rentas.hasMoreElements()){
			Renta cadaRenta = rentas.nextElement();

			double monto = cadaRenta.monto();
			puntosRentaFrecuente += cadaRenta.puntosRentaFrecuente();
			
			resultado += "\t" + cadaRenta.get_pelicula().get_titulo()+"\t" + String.valueOf(monto) + "\n";
			montoTotal += monto;
		}
		
		resultado += "Monto ganado es" + String.valueOf(montoTotal) + "\n";
		resultado += "Ganaste "+ String.valueOf(puntosRentaFrecuente) + "puntos";
		
		return resultado;
	}
}
