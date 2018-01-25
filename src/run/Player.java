package run;

import java.util.ArrayList;
import java.util.List;

import engine.main.Runner;
import engine.util.Vector2f;

public class Player extends Runner{

	protected Player(boolean full, int width, int height, String title, int fps, int tps) {
		super(full, width, height, title, fps, tps);
	}

	List<Firework> rockets = new ArrayList<Firework>();
	List<Particle> sparks = new ArrayList<Particle>();

	@Override
	public void tick() {
		if(Math.random() < 0.4D){
			rockets.add(new Firework(new Vector2f(Math.random()*(width + 0D), height), new Vector2f(2-(Math.random()*4), -(40+(Math.random()*10D)))));
		}
		for(int i = 0; i < rockets.size(); i++){
			rockets.get(i).update(rockets, i, sparks);
		}
		
		for(int i = 0; i < sparks.size(); i++){
			sparks.get(i).update(sparks, i);
		}
	}

	@Override
	public void render() {
		for(int i = 0; i < rockets.size(); i++){
			rockets.get(i).render(g);
		}
		
		for(int i = 0; i < sparks.size(); i++){
			if(sparks.get(i) != null){
				sparks.get(i).render(g);
			}
		}
	}
}
