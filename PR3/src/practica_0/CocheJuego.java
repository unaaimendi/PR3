package practica_0;

public class CocheJuego extends Coche {
	
	private JLabelCoche miCarro;
	
	
	public CocheJuego(){
		// TODO Auto-generated constructor stub
		miCarro = new JLabelCoche();
	}


	
	/*public CocheJuego(double miVelocidad, double miDireccionActual, double posX, double posY, String piloto, JLabelCoche miCarro) {
		super(miVelocidad, miDireccionActual, posX, posY, piloto);
		this.miCarro = miCarro;
		// TODO Auto-generated constructor stub
	}*/
	
	
	public JLabelCoche getMiCarro() {
		return miCarro;
	}

	public void setMiCarro(JLabelCoche miCarro) {
		this.miCarro = miCarro;
	}
	public JLabelCoche getGrafico() {
		return miCarro;
	}

	@Override
	public void setMiDireccionActual(double miDireccionActual) {
		// TODO Auto-generated method stub
		super.setMiDireccionActual(miDireccionActual);
		miCarro.setGiro( miDireccionActual );
		miCarro.repaint();
	}

	@Override
	public void setPosX(double posX) {
		// TODO Auto-generated method stub
		super.setPosX(posX);
		miCarro.setLocation( (int)posX, (int)posY );
		miCarro.repaint();
	}

	@Override
	public void setPosY(double posY) {
		// TODO Auto-generated method stub
		super.setPosY(posY);
		miCarro.setLocation( (int)posX, (int)posY );
		miCarro.repaint();

	}
	

}
