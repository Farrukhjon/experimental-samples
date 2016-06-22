package org.farrukh.examples.patterns.structural.facade.ch2;

import org.farrukh.examples.patterns.structural.facade.ch2.subSystem.DVDPlayer;
import org.farrukh.examples.patterns.structural.facade.ch2.subSystem.PopcornPopper;
import org.farrukh.examples.patterns.structural.facade.ch2.subSystem.Projector;
import org.farrukh.examples.patterns.structural.facade.ch2.subSystem.Screen;
import org.farrukh.examples.patterns.structural.facade.ch2.subSystem.TheaterLights;
import org.farrukh.examples.patterns.structural.facade.ch2.subSystem.Tuner;

public class HomeTheaterFacade {

	private Tuner			tuner;
	private DVDPlayer		dvdPlayer;
	private Projector		projector;
	private Screen			screen;
	private TheaterLights	lights;
	private PopcornPopper	popcornPopper;

	public HomeTheaterFacade(Tuner tuner, DVDPlayer dvdPlayer, Projector projector, Screen screen, TheaterLights lights, PopcornPopper popcornPopper) {
		super();
		this.tuner = tuner;
		this.dvdPlayer = dvdPlayer;
		this.projector = projector;
		this.screen = screen;
		this.lights = lights;
		this.popcornPopper = popcornPopper;
	}

	public void watchMove(String move) {
		tuner.on();
		dvdPlayer.on();
		projector.on();
		screen.adjust(0, 12, 1, 0);
		lights.off();
	}

	public void endMove() {
		tuner.off();
		dvdPlayer.off();
		projector.off();
		screen.adjust(0, 0, 0, 0);
		lights.on();
	}

	public PopcornPopper getPopcornPopper() {
		return popcornPopper;
	}

	public void setPopcornPopper(PopcornPopper popcornPopper) {
		this.popcornPopper = popcornPopper;
	}

}
