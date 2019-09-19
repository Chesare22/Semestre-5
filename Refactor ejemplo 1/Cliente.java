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
			double monto =  0;
			Renta cadaRenta = rentas.nextElement();
			
			switch(cadaRenta.get_pelicula().get_precio()){
				case Pelicula.NORMALES:
					monto += 2;
					if (cadaRenta.get_diasRentado() > 2)
						monto += (cadaRenta.get_diasRentado() - 2) * 1.5;
					break;
				case Pelicula.ESTRENOS:
					monto += cadaRenta.get_diasRentado() * 3;
					break;
				case Pelicula.NINIOS:
					monto += 1.5;
					if(cadaRenta.get_diasRentado() > 3)
						monto += (cadaRenta.get_diasRentado() - 3) * 1.5;
					break;
			}
			puntosRentaFrecuente ++;
			
			if((cadaRenta.get_pelicula().get_precio() == Pelicula.ESTRENOS) &&
					cadaRenta.get_diasRentado() > 1)
				puntosRentaFrecuente++;
			
			resultado += "\t" + cadaRenta.get_pelicula().get_titulo()+"\t" + String.valueOf(monto) + "\n";
			montoTotal += monto;
			
			
		}
		
		resultado += "Monto ganado es" + String.valueOf(montoTotal) + "\n";
		resultado += "Ganaste "+ String.valueOf(puntosRentaFrecuente) + "puntos";
		
		return resultado;
		
	}
}
