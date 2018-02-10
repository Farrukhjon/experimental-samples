package org.farrukh.experiments.dp.structural.composite.ch2;

public class Client {

	public static void main(String[] args) {

		SongComponent loveSongsGroup = new SongGroup("Loves", "Songs about loves story");
		
		loveSongsGroup.add(new Song("Sultoni qalbam", "Ahmad Zahir", 1975));
		loveSongsGroup.add(new Song("Be tu gulgashte chaman", "Ahmad Zahir", 1974));
		loveSongsGroup.add(new Song("Dili devona", "Ahmad Zahir", 1974));

		SongComponent liricSongsGroup = new SongGroup("Liric", "Songs about liric");
		
		liricSongsGroup.add(new Song("Man nadanistam as awal", "Ahmad Zahir", 1970));
		liricSongsGroup.add(new Song("Ay Sorbon", "Ahmad Zahir", 1971));

		SongComponent allSongsAndGroups = new SongGroup("All", "All collection of Ahmad Zahir songs");

		allSongsAndGroups.add(loveSongsGroup);
		allSongsAndGroups.add(liricSongsGroup);
		
		allSongsAndGroups.add(new Song("Ba osumon bigued", "Ahmad Zahir", 1970));
		allSongsAndGroups.add(new Song("Gufta budam", "Ahmad Zahir", 1970));
		allSongsAndGroups.add(new Song("Digar ashkam marez", "Ahmad Zahir", 1970));
		
		DiskAhmadZahir disk = new DiskAhmadZahir(allSongsAndGroups);
		disk.showSongList();
	}
}
