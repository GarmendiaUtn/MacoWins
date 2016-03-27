
public class Internacional extends Prenda{
	public Internacional(TipoPrenda unTipoPrenda) {
		super(unTipoPrenda);
		// TODO Auto-generated constructor stub
	}

	public Double precioCon(Double unValorFijo){
		return (super.precioCon(unValorFijo)*1.3);
	}

}
