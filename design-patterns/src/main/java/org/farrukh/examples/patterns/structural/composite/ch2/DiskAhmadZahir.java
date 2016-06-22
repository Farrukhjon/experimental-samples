package org.farrukh.examples.patterns.structural.composite.ch2;

public class DiskAhmadZahir {

	private SongComponent	songList;

	public DiskAhmadZahir(SongComponent songList) {
		this.songList = songList;
	}

	public void showSongList() {
		songList.displaySongInfo();
	}

}
