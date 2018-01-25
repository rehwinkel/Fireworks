package run;

import java.awt.Color; 
import java.awt.Graphics2D;
import java.util.List;

import engine.util.DrawMethod;
import engine.util.Vector2f;

public class Firework extends Particle{

	public Firework(Vector2f pos, Vector2f vel) {
		super(pos, vel, getHSVColor((int) (Math.random() * 360)), 10000);
	}

	public void update(List<Firework> parts, int i, List<Particle> sparks){
		super.update(null, 0);
		if(this.vel.y > 0){
			this.explode(parts, i, sparks);
		}
	}

	private void explode(List<Firework> parts, int i, List<Particle> sparks) {
		for(int e = 0; e < 100; e++){
			sparks.add(new Particle(pos, Vector2f.mult(Vector2f.random(), 10), col, 10));
		}
		killS(parts, i);
	}
	
	private void killS(List<Firework> parts, int i) {
		parts.remove(i);
	}
	
	@Override
	public void render(Graphics2D g){
		g.setColor(col);
		DrawMethod.fillCircle((int) pos.x, (int) pos.y, 3, g);
	}
	
	public static Color getHSVColor(int deg) {
		int r = 0;
		int g = 0;
		int b = 0;
		
		if(deg >= 0 && deg <= 60){
			r = 255;
			b = 0;
			g = (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 60 && deg <= 120){
			r = 255 - (int) ((deg % 60 / 60.0f) * 255);
			g = 255;
			b = 0;
		}
		if(deg > 120 && deg <= 180){
			r = 0;
			g = 255;
			b = (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 180 && deg <= 240){
			r = 0;
			b = 255;
			g = 255 - (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 240 && deg <= 300){
			g = 0;
			b = 255;
			r = (int) ((deg % 60 / 60.0f) * 255);
		}
		if(deg > 300 && deg <= 360){
			g = 0;
			r = 255;
			b = 255 - (int) ((deg % 60 / 60.0f) * 255);
		}
		
		return new Color(r, g, b);
	}

}
