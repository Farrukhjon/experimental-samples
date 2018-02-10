package org.farrukh.experiments.dp.structural.facade.ch2;

import org.farrukh.experiments.dp.structural.facade.ch2.subSystem.DVDPlayer;
import org.farrukh.experiments.dp.structural.facade.ch2.subSystem.PopcornPopper;
import org.farrukh.experiments.dp.structural.facade.ch2.subSystem.Projector;
import org.farrukh.experiments.dp.structural.facade.ch2.subSystem.Screen;
import org.farrukh.experiments.dp.structural.facade.ch2.subSystem.TheaterLights;
import org.farrukh.experiments.dp.structural.facade.ch2.subSystem.Tuner;

public class Client {

	public static void main(String[] args) {

		HomeTheaterFacade facade = new HomeTheaterFacade(new Tuner(), new DVDPlayer(), new Projector(), new Screen(), new TheaterLights(), new PopcornPopper());
		facade.watchMove("Terminator 1");
		facade.endMove();
	}

}
