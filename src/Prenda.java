
public abstract class Prenda {
	private TipoPrenda tipoPrenda;
	
	public Prenda(TipoPrenda unTipoPrenda){
		tipoPrenda = unTipoPrenda;
	}
	public TipoPrenda tipoPrenda(){
		return tipoPrenda;
	}
	public Double precioCon(Double unValorFijo){
		return tipoPrenda.precioBase() + unValorFijo;
	}
}
