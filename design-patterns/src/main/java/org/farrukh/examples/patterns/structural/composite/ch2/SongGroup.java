package org.farrukh.examples.patterns.structural.composite.ch2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SongGroup extends SongComponent {

	private List<SongComponent>	songComponents	= new ArrayList<SongComponent>();

	private String				groupName;
	private String				groupDescription;

	public SongGroup(String groupName, String groupDescription) {
		this.groupName = groupName;
		this.groupDescription = groupDescription;
	}

	public String getGroupName() {
		return groupName;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	@Override
	public void add(SongComponent newSongComponent) {
		songComponents.add(newSongComponent);
	}

	@Override
	public void remove(SongComponent newSongComponent) {
		songComponents.remove(newSongComponent);
	}

	@Override
	public SongComponent getComponent(int componentIndex) {
		return songComponents.get(componentIndex);
	}

	@Override
	public void displaySongInfo() {
		System.out.printf("%-5s %1s %-3s %n", getGroupName(), "---", getGroupDescription());

		Iterator<SongComponent> iterator = songComponents.iterator();

		while (iterator.hasNext()) {
			SongComponent component = iterator.next();
			component.displaySongInfo();
		}
	}

}
