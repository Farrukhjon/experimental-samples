package org.farrukh.experiments.dp.structural.composite.ch2;

public class Song extends SongComponent {

	private String	songName;
	private String	bandName;
	private int		releaseYear;

	public Song(String songName, String bandName, int releaseYear) {
		this.songName = songName;
		this.bandName = bandName;
		this.releaseYear = releaseYear;
	}

	public String getSongName() {
		return songName;
	}

	public String getBandName() {
		return bandName;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	@Override
	public void displaySongInfo() {
		System.out.printf("%-25s %10s %-5s %5s %-5s %n", getSongName(), " was recorded by ", getBandName(), " in ", getReleaseYear());
	}

}
