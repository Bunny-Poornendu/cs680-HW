package edu.umb.cs680.hw14;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw14.ApfsDirectory;
import edu.umb.cs680.hw14.ApfsFSElement;
import edu.umb.cs680.hw14.ApfsFile;
import edu.umb.cs680.hw14.ApfsLink;

public class ApfsDirectoryTest {
	private static ApfsDirectory root;
	private static ApfsDirectory apps;
	private static ApfsDirectory bin;
	private static ApfsDirectory home;
	private static ApfsDirectory pictures;
	private static ApfsFile x;
	private static ApfsFile y;
	private static ApfsFile a;
	private static ApfsFile b;
	private static ApfsFile c;
	private static ApfsLink m;
	private static ApfsLink n;
	

	@BeforeAll
	static void setUp() throws Exception {
		root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		apps = new ApfsDirectory(root, "apps", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		bin = new ApfsDirectory(root, "bin", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		pictures = new ApfsDirectory(home, "pictures", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		x = new ApfsFile(apps, "x", 100, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		y = new ApfsFile(bin, "y", 20, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		a = new ApfsFile(pictures, "a", 30, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		b = new ApfsFile(pictures, "b", 80, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		c = new ApfsFile(home, "c", 50, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime");
		m = new ApfsLink(home, "m", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime", bin);
		n = new ApfsLink(pictures, "n", 0, LocalDateTime.now(), "defaultOwnerName", "defaultLastModifiedTime", y);
		root.appendChild(apps);
		root.appendChild(bin);
		root.appendChild(home);
		apps.appendChild(x);
		apps.appendChild(y);
		home.appendChild(pictures);
		home.appendChild(c);
		home.appendChild(m);
		pictures.appendChild(a);
		pictures.appendChild(b);
		pictures.appendChild(n);
	}

	private String[] dirToStringArray(ApfsDirectory d) {
		String[] dirInfo = { String.valueOf(d.isDirectory()), d.getOwnerName(), String.valueOf(d.getTotalSize()),
							d.getLastModifiedTime(), String.valueOf(d.countChildren()) };
		return dirInfo;
	}


	@Test
	public void InstanceDirectoryEqualityCheckRoot() {
		String[] expected = { "true", "defaultOwnerName", "280", "defaultLastModifiedTime", "3" };
		ApfsDirectory actual = root;
		assertArrayEquals(expected, dirToStringArray(actual));
	}

	@Test
	public void InstanceDirectoryEqualityCheckHome() {
		String[] expected = {"true", "defaultOwnerName", "160", "defaultLastModifiedTime", "3"};
		ApfsDirectory actual = home;
		assertArrayEquals(expected, dirToStringArray(actual));
	}
	
	@Test
	public void verifyRootisDirectoy() {
		assertTrue(root.isDirectory());
	}
	
	@Test
	public void verifyifRootisFile() {
		assertFalse(root.isFile());
	}
	
	@Test
	public void verifyifRootisLink() {
		assertFalse(root.isLink());
	}
	
	@Test
	public void verifyappendChildrenWithRoot() {
		assertSame(root, apps.getParent());
	}
	
	@Test
	public void verifyappendChildrenWithHome() {
		assertSame(home, c.getParent());
	}

	
	@Test
	public void verifyChildrenOfHome() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = c;
		expected[1] = m;
		expected[2] = pictures;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren();
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyReverseAlphabeticalForChildrenOfHome() {
		ApfsFSElement[] expected = new ApfsFSElement[3];
		expected[0] = pictures;
		expected[1] = m;
		expected[2] = c;
		ApfsFSElement[] actual = new ApfsFSElement[3];
		LinkedList<ApfsFSElement> children = home.getChildren(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = children.get(0);
		actual[1] = children.get(1);
		actual[2] = children.get(2);
		assertArrayEquals(expected, actual);
	}

	
	@Test
	public void verifyRootSubDirectories() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories();
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyReverseAlphabeticalForRootSubDirectories() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = home;
		expected[1] = bin;
		expected[2] = apps;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyElementKindForRootSubDirectories() {
		ApfsDirectory[] expected = new ApfsDirectory[3];
		expected[0] = apps;
		expected[1] = bin;
		expected[2] = home;
		ApfsDirectory[] actual = new ApfsDirectory[3];
		LinkedList<ApfsDirectory> subDirectories = root.getSubDirectories(Comparator.comparing(e -> e.elementKindToInt()));
		actual[0] = subDirectories.get(0);
		actual[1] = subDirectories.get(1);
		actual[2] = subDirectories.get(2);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifySubDirectoriesOfHome() {
		assertSame(pictures, home.getSubDirectories().get(0));
	}
	
	@Test
	public void verifyFilesOfHome() {
		assertSame(c, home.getFiles().get(0));
	}
	
	@Test
	public void verifyFilesOfPictures() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = a;
		expected[1] = b;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles();
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void verifyReverseAlphabeticalForFilesOfPictures() {
		ApfsFile[] expected = new ApfsFile[2];
		expected[0] = b;
		expected[1] = a;
		ApfsFile[] actual = new ApfsFile[2];
		LinkedList<ApfsFile> files = pictures.getFiles(Comparator.comparing(e -> e.getName(), Comparator.reverseOrder()));
		actual[0] = files.get(0);
		actual[1] = files.get(1);
		assertArrayEquals(expected, actual);
	}


}
